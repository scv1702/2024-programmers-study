# 문제 풀이

## 문제 해설

본 문제는 구현 문제로 문제에서 설명한 대로 배열을 탐색하면 된다. 필자는 처음에 주어진 $n$에 따라 일차원 배열을 탐색하도록 만들려고 했는데, 방향을 전환하는 과정에서 많은 어려움을 겪었다. 그래서 다른 답안을 참고했는데 문제를 2차원 배열로 모델링하면 아주 쉽게 방향 전환이 가능하다는 것을 깨달았다.

문제를 풀다가 너무 어렵게 풀고 있는게 아닐까라는 생각이 들면, 문제를 다른 시각으로 보면서 평소 사용하던 기법을 어떻게 하면 적용할 수 있을까 생각해보자.

## 시간 복잡도

$n \times n$의 2차원 배열에 대해서 탐색을 하기 때문에 전체 시간 복잡도는 $O(n^2)$이다.
