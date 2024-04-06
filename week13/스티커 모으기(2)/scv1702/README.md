# 문제 풀이

## 문제 해설

스티커가 원형이 아닌 경우 한 번의 선형 탐색을 통해 문제를 해결할 수 있지만, 스티커가 원형이기 때문에 가장 첫 번째 스티커를 떼는 경우와 떼지 않는 경우를 모두 계산해야 한다.

### 1. Subproblem
$dp(i)$: $sticker[i]$까지 탐색했을 때 숫자 합의 최대값

### 2. Relation
$dp(i) = max(dp(i-2) + sticker[i], dp(i-1))$

### 3. Topology
$sticker$의 길이를 $n$이라고 하자.

$sticker[0]$을 떼는 경우, `for i in range(n - 1)`

$sticker[0]$을 떼지 않는 경우, `for i in range(n)`

### 4. Base case

$sticker[0]$을 떼는 경우, $dp(0) = sticker[0]$, $dp(1) = max(dp(0), sticker[1])$

$sticker[0]$을 떼지 않는 경우, $dp(0) = 0$, $dp(1) = sticker[1]$

### 5. Original problem

$dp(n)$

### 6. Time complexity

$sticker[0]$을 떼는 경우와 떼지 않는 경우 총 2번에 대해 계산해야 하므로 $O(2\times n)$이다.