# 문제 풀이

## 문제 해설

본 문제는 `(0, 0)`에서 `(N-1, N-1)`로 가는 경로 중 최소 건설 비용을 탐색하는 문제다. 처음 생각했을땐 일반적인 BFS를 통해 문제를 해결할 수 있을 것 같았으나, 현재까지 건설 비용이 동일하더라도 이전 탐색 방향에 따라 다음 건설 비용이 달라질 수 있기 때문에 이는 불가능했다. 즉, 단순 위치에 대한 배열로 탐색을 이어갈지 말지 판단하는 것이 아닌, 방향에 대한 정보도 같이 고려해야 한다는 것이다.

```java
public int solution(int[][] board) {
    int n = board.length;
    int answer = Integer.MAX_VALUE;
    int[][] costs = new int[n * n][dirs.length];
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    
    queue.offer(new int[] { 0, -1, 0 });
    ...
}
```

`queue`에는 이전 위치, 이전 탐색 방향, 이전까지 건설 비용 정보가 저장된다. 첫 시작 위치인 `(0, 0)`은 이전 탐색 방향이 없기 때문에 `-1`로 처리했다.

```java
while (!queue.isEmpty()) {
    int[] cur = queue.poll();
    
    int pos = cur[0];
    int d = cur[1];
    int cost = cur[2];
    
    int r = pos / n;
    int c = pos % n;
    
    if (r == n - 1 && c == n - 1) {
        answer = Math.min(answer, cost);
        continue;
    }
    ...
}
```

현재 위치가 도착점인 경우 `answer`를 갱신한다. 다만, 다음 탐색시 `answer`보다 더 적은 건설 비용을 찾을 수도 있기 때문에 탐색을 종료하지 않는다.

```java
while (!queue.isEmpty()) {
    ...
    for (int nd = 0; nd < dirs.length; nd++) {
        int nr = r + dirs[nd][0];
        int nc = c + dirs[nd][1];
        if (!validate(board, nr, nc)) continue;
        int npos = nr * n + nc;
        int ncost = 100;
        if (d >= 0) {
            ncost += cost + (dotp(d, nd) == 0 ? 500 : 0);
        }
        if (costs[npos][nd] == 0 || ncost < costs[npos][nd]) {
            costs[npos][nd] = ncost;
            queue.offer(new int[] { npos, nd, ncost });
        }
    }
}
```

 `npos`는 현재 위치, `nd`는 현재 탐색 방향, `ncost`는 현재까지 건설 비용을 의미한다. 이때 이전 방향과 현재 탐색 방향의 내적 `dotp()`를 통해 코너를 건설할지 말지 판단한다. 만약 기존의 `npos`까지 필요한 건설 비용 `costs[npos][nd]`보다 건설 비용이 더 적은 경로를 찾았다면 건설 비용을 갱신하고 탐색을 이어간다. 그렇지 않다면 더 탐색을 해도 비용을 줄일 수 없기 때문에 탐색을 중지한다.

## 시간 복잡도

일반적인 BFS와 달리 정점을 여러번 방문하는데.. 시간 복잡도를 어떻게 구해야할 지 모르겠다. 탐색하는 그래프의 정점 개수는 $4 \times n^2$이다.