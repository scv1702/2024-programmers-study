# 문제 풀이

## 문제 해설

본 문제를 읽어보면 DP로 풀어야한다는 생각이 떠오를 것이다. 금액 `n`을 만드는 경우의 수는 금액 `n - money[i]`를 만드는 경우의 수에 1을 더한 값이기 때문이다. 경우의 수를 세릴때 중요한 것은, 중복을 포함하면 안된다는 것이다. 중복을 포함하지 않기 위해 다음과 같이 사용하는 화폐 개수를 저장해두어, `mem[i]`를 계산할 때 `mem[i - money[j]]` 중에서 `money[j]`보다 작거나 같은 화폐로 만든 경우만 더해주었다.

```java
int answer = 0;
int m = money.length;
int[][] mem = new int[n + 1][m];
mem[money[0]][0] = 1;

for (int i = money[0] + 1; i <= n; i++) {
    for (int j = 0; j < m; j++) {
        if (i < money[j]) continue;
        for (int k = 0; k <= j; k++) {
            mem[i][j] += (mem[i - money[j]][k] % MOD);
        }
        if (i == money[j]) {
            mem[i][j] = 1;
        }
    }
}

for (int i = 0; i < m; i++) {
    answer += (mem[n][i] % MOD);
}
```

그러나 위 방법은 시간 복잡도가 $O(nm^2)$이기 때문에 시간 초과가 날 수 밖에 없다. 그래서 관점을 만드는 금액이 아닌, 화폐로 바꾸어 보았다. 가장 작은 화폐부터 시작해 점점 화폐의 종류를 추가하는 것이다. 화폐 금액을 점점 키워나가기 때문에 중복이 발생하지 않는다.

```java
int m = money.length;
int[] mem = new int[n + 1];

for (int i = 0; i < m; i++) {
    for (int j = money[i]; j <= n; j++) {
        mem[j] += (mem[j - money[i]]) % MOD;
        if (j == money[i]) {
            mem[j] += (1 % MOD);
        }
    }
}
```

## 시간 복잡도

전체 시간 복잡도는 $O(nm)$이다.