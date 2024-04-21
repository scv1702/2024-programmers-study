# 문제 풀이

## 문제 해설

본 문제는 문자열 `s`가 주어질 때 `s[i:j]`과 펄스 수열의 내적의 최대값을 찾는 문제다. 부분 수열의 합은 수열의 누적합을 구해놓으면 $O(1)$에 구할 수 있다.

```java
int n = sequence.length;
long[] ps = new long[n + 1];

for (int i = 1; i <= n; i++) {
    ps[i] = ps[i-1] + (sequence[i-1] * (i % 2 == 0 ? -1 : 1));
}
```

`ps`는 `sequence`에 시작이 `1`인 펄스 수열 `[1, -1, 1, ...]`을 곱한  것의 누적합이다. 부분 문자열이 `s[i:j+1]`일 때, 시작이 `1`인 펄스 수열과 내적은 `ps[j] - ps[i-1]`, 시작이 `-1`인 펄스 수열과 내적은 `ps[i-1] - ps[j]`이다.

누적합은 $O(n)$에 계산할 수 있지만, 정답을 구하는 것이 문제이다. 모든 부분 수열의 경우의 수, 즉 $(i, j)$ 쌍은 $O(n^2)$개이기 때문에 시간 초과가 날 수 밖에 없다.

```java
long answer = Long.MIN_VALUE;

for (int j = 1; j <= n; j++) {
    for (int i = 1; i <= j; i++) {
        long res = ps[j] - ps[i - 1];
        answer = Math.max(answer, Math.max(res, -res));
    }
}
```

위 반복문은 `ps[j] - ps[i - 1]`의 최대값을 구하고 있다. 해당 값이 최대가 되려면, `ps[j]`를 고정값이라고 할 때 `ps[i - 1]`이 최대한 작아야 한다. 또한 `i <= j`라는 점을 고려하면 다음과 같이 `ps[i - 1]`의 최소값을 계속 저장함으로써 $O(n)$으로 줄일 수 있다.

```java
long answer = Long.MIN_VALUE;
long pm = 0; // 시작이 1인 펄스 수열
long mm = 0; // 시작이 -1인 펄스 수열

for (int i = 1; i <= n; i++) { 
    answer = Math.max(answer, Math.max(ps[i] - pm, -ps[i] - mm));
    pm = Math.min(pm, ps[i]);
    mm = Math.min(mm, -ps[i]);
}
```

## 시간 복잡도

전체 시간 복잡도는 $O(n)$이다.