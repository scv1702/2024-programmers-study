# 문제 풀이

## 문제 해설

양방향 이동이 필요하고, 삽입과 삭제가 자주 발생하기 때문에 double linked list를 이용해 표를 나타냈다. double linked list에서 삽입과 삭제는 $O(1)$이다. 그러나 random access가 불가능한데, 이번 문제에서 이동 거리의 총합 `X`가 $10^6$ 이하이기 때문에 시간 제한 내에 이동을 마칠 수 있다. 

최근 삭제한 행을 복구하기 위해 stack에 삭제된 행들을 저장했다. 복구 요청이 올때마다 stack에서 행을 꺼낸다.

주의할 점은 `NullPointerException`과 double linked list의 head를 잘 관리해야하는 것이다. head 행을 삭제 및 복구할 때마다 head를 잘 옮겨줘야 한다.

## 시간 복잡도

전체 시간 복잡도는 $O(n + sum(X))$이다.