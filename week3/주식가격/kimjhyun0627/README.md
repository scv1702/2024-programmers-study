  # 문제 풀이

## 문제 해설


**스택**


*뒤에 있는 큰 수 찾기와 같은 문제*

1. answer 배열을 -1로 채워준다.
2. stack에 numbers 배열의 index를 채워주며 반복문에서 새롭게 들어오는 수가 stack의 값보다 더 작은 지점까지 answer를 계산해 채워간다.
3. 반복문이 끝난 후, 끝까지 가격이 떨어지지 않은 항목들에 대한 계산을 위한 반복문을 추가한다.



## 시간 복잡도

$$O(len(prices))$$