# 문제 풀이

## 문제 해설

카카오프렌즈는 총 8명으로 8명이 줄을 서는 경우의 수는 $8!$이다. 그러므로 완전 탐색을 통해 문제를 해결할 수 있다. 각 순열마다 주어진 조건을 만족하는지 판단한다.

## 시간 복잡도

카카오프렌즈가 $m$ 명, 주어진 조건의 개수를 $n$ 이라고 할 때, $O(m! \times m \times n)$이다.