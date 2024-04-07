  # 문제 풀이

## 문제 해설

***bfs***


1. 주어진 edge list를 바탕으로 graph dictionary를 생성한다.
2. deque를 통해 queue를 생성해 bfs 탐색한다. 현재 위치에서 접근 가능한 vertex 중 distance가 inf인 곳이 있다면 현재 위치의 값 + 1한 값으로 수정하고 queue에 append한다.
3. 1번 vertex를 제외한 나머지 vertex들 중 가장 큰 값의 개수를 반환한다.


## 시간 복잡도

$$O(edge*log(edge))$$

