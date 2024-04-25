  # 문제 풀이

## 문제 해설

***딕셔너리 구현***


1. 개인별 추천인과 소득을 담을 dictionary를 생성한다.
2. enroll을 순회하며 두 dictionary를 채운다.
3. seller를 순회하며 루트 노드에 이를때까지 profit을 10등분하여 분배하는 작업을 거친다. 다음 추천인이 루트 노드라면 while문을 종료하고 10등분한 값을 빼주기만 한다.
4. answer list에 계산한 profit을 append해 반환한다.

## 시간 복잡도

$$O(seller * referral)$$

