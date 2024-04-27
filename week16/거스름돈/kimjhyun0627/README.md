  # 문제 풀이

## 문제 해설

***dp***

1. dp list를 만든다.
2. sort한 money에 대해서 순회한다.
3. m~n 구간을 순회하며 index가 m이라면 +1, 아니라면 본인과 index-m한 값을 더한 후 mod해준다.
4. dp[n]을 반환한다.

## 시간 복잡도

$$O(len(money)*log(n))$$

