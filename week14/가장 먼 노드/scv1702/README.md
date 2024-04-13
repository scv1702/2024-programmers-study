# 문제 풀이

## 문제 해설

1번 노드에서 최단 경로로 가장 멀리 떨어진 노드의 개수를 구해야 한다. 주어진 그래프의 간선의 가중치는 존재하지 않기 때문에 BFS를 사용하면 1번 노드에서 각 정점까지 최단 경로로 탐색할 수 있다.

각 탐색 시 현재까지 탐색한 깊이를 저장해서 `counts[depth]`에 저장하는 방법도 있지만, 가장 멀리 떨어진 노드는 terminal node, 즉 인접한 노드가 없기 때문에 이를 이용하면 된다.

```java
while (!queue.isEmpty()) {
    int node = queue.poll();
    boolean isNotTerminalNode = false;
    for (int next = 0; next < n; next++) {
        if (graph[node][next] && !visited[next]) {
            visited[next] = true;
            queue.offer(next);
            isNotTerminalNode = true;
        }
    }
    if (isNotTerminalNode) {
        answer += 1;
    }
}
```

## 시간 복잡도

인접 행렬에 대해 BFS를 수행했기 때문에 $O(n^2)$이다.