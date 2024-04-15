# 문제 풀이

## 문제 해설

먼저 `s[i:j+1]`가 팰린드롬이면 `len(s[i:j+1])`을, 아니면 `-1`을 반환하는 함수를 만들자. 이 함수는 재귀를 이용해 작성할 수 있다. 이 함수는 `i`와 `j`를 부분 문자열의 양 끝에서 시작해 서로 만날 때까지 재귀 호출을 반복한다.

```java
public int solve(String s, int i, int j, int[][] mem) {
    if (i < 0 || i >= s.length() || j < 0 || j >= s.length() || i > j) {
        return 0;
    }
    if (i == j) {
        return 1;
    }
    if (s.charAt(i) != s.charAt(j)) {
        return -1;
    }
    int res = solve(s, i + 1, j - 1, mem);
    if (res == -1) {
        return -1;
    }
    return res + 2;
}
```

본 문제는 `s`의 부분 문자열 중에서 가장 긴 팰린드롬을 찾아야 하기 때문에, 다음과 같이 2중 `for`문을 사용해 가능한 모든 경우 부분 문자열을 탐색해야 한다.

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        answer = Math.max(answer, solve(s, i, j, mem));
    }
}
```

그러나 이렇게 하면 $O(n^3)$이기 때문에 시간 초과가 날 수 밖에 없다. 여기서 memoization 기법을 사용해 재귀 함수의 결과를 caching 한다.

```java
private static final int NULL = 2501;

public int solve(String s, int i, int j, int[][] mem) {
    if (i < 0 || i >= s.length() || j < 0 || j >= s.length() || i > j) {
        return 0;
    }
    if (mem[i][j] != NULL) {
        return mem[i][j];
    }
    if (i == j) {
        mem[i][j] = 1;
        return 1;
    }
    if (s.charAt(i) != s.charAt(j)) {
        mem[i][j] = -1;
        return -1;
    }
    int res = solve(s, i + 1, j - 1, mem);
    if (res == -1) {
        mem[i][j] = -1;
        return -1;
    }
    mem[i][j] = res + 2;
    return res + 2;
}
```

memoization을 통해 불필요한 재귀 호출을 획기적으로 줄일 수 있다. 

## 시간 복잡도

전체 시간 복잡도는 $O(n^2)$이다.