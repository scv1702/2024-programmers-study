# 문제 풀이

## 문제 해설

주어진 `timetable`에 따라 다양한 케이스가 있을 수 있기 때문에 몇시에 줄을 서야하는지 값을 탐색하기 보다는 전체 가능한 경우의 수 중에서 최대값을 찾는 방식을 택했다. 가능한 경우의 수 중 최대값은 `toMinute(09:00) + (n-1) * t`, 최소값은 `0`이다.

```java
int[] times = Arrays.stream(timetable)
    .mapToInt((time) -> toMinute(time))
    .sorted()
    .toArray();
int min = times[0];
int max = times[times.length - 1];
int last = toMinute("09:00") + (n - 1) * t;

for (int ans = last; ans >= 0; ans--) {
    ...
}

return toString(0);
```

이제 `for`문 안에서 `ans`가 정답에 해당하는지 판단을 하게 된다. `search(int[] array, int num)`은 이진 탐색 함수로, `num`이 `array`에 있는 경우 중복되는 값들 중 가장 오른쪽에 위치한 값의 인덱스를, 그렇지 않은 경우 `insertion point - 1`을 반환한다. `insert()`를 통해 `times`에 `ans`를 올바른 위치에 배치시킨다. `insert()`는 새로운 배열을 만들어 복사를 하기 때문에 $O(N)$이 걸린다.

```java
for (int ans = last; ans >= 0; ans--) {
    int idx = search(times, ans);
    int[] res = insert(times, idx + 1, ans);
    if (validate(res, n, t, m, idx + 1)) {
        return toString(ans);
    }
}
```

여기서 중요한 함수는 `validate()`이다. 주어진 `times`에서, `idx`에 위치한 손님이 버스를 탈 수 있는지 없는지 판단한다. 

```java
public boolean validate(int[] times, int n, int t, int m, int idx) {
    int last = toMinute("09:00") + (n - 1) * t;
    int i = 0;
    int j = 0;
    
    for (int time = toMinute("09:00"); time <= last; time += t) {
        // time[i:j]를 버스에 태운다. 
        for (; j < times.length && j < i + m && times[j] <= time; j++) { 
            continue;
        }
        if (idx < j) {
            return true;
        }
        i = j;
    }
    
    return false;
}
```

## 시간 복잡도

전체 시간 복잡도는 $O(1439 \times N)$이다.