# 문제 풀이

## 문제 해설
행렬의 곱셈 정의에 따라 동일하게 구현하면 된다.

## 시간 복잡도

`arr1` 행렬을 `m x k`, `arr2` 행렬을 `k x n`이라고 했을 때 행렬의 곱셈 시간 복잡도는 `O(mnk)`이다.

```java
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int m = arr1.length;
        int k = arr1[0].length;
        int n = arr2[0].length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = 0; p < k; p++) {
                    answer[i][j] += arr1[i][p] * arr2[p][j];
                }
            }
        }
        return answer;
    }
}
```