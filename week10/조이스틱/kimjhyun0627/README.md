  # 문제 풀이

## 문제 해설

***왜 그리디?***

1. 반복문을 순회하며 한 칸씩 이동하며 피벗의 왼쪽->오른쪽 순서와 오른쪽->왼쪽 순서를 비교한다.
2. 양쪽 끝의 A는 필요가 없으므로 다 떼준다.
3. 두 방향 중 더 적은 쪽을 선택한다.
4. 선택한 방향에서의 상하 이동 횟수와 좌우 이동 횟수를 더해서 answer와 비교한다.

## 시간 복잡도

$$O(len(name)^2)$$

