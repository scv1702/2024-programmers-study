# 문제 풀이

## 문제 해설

백트래킹을 통해 문제를 해결했다. 주어진 `tickets`을 문제의 조건에 따라 가능한 경로가 2개 이상인 경우 알파벳 순으로 탐색을 진행하기 위해 정렬을 했다.

```java
int n = tickets.length + 1;
boolean[] visited = new boolean[tickets.length];
answer = new String[n];

Arrays.sort(tickets, (t1, t2) -> t1[1].compareTo(t2[1]));
```

다음과 같이 `"ICN"`에서부터 DFS를 시작한다. DFS를 통해 각 항공권을 한 번씩 방문한다. 마지막에 도달했을 때 모든 항공권을 사용하지 않은 경우, 다른 경로를 탐색한다.

```java
dfs(graph, "ICN", visited, 0, n);
```

백트래킹을 진행하면서 가장 먼저 `depth`가 `n-1`이 되면 정답을 찾은 것이기 때문에 `flag = true`를 하고 `return`을 한다. 이를 하지 않으면 정답을 찾았음에도 불구하고 탐색을 이어나기기 때문에 정답이 알파벳 내림차순으로 덮어 씌워지게 된다.

```java
public void dfs(
    String[][] tickets,
    String u,
    boolean[] visited,
    int depth,
    int n
) {
    if (flag) {
        return ;
    }
    answer[depth] = u;
    for (int i = 0; i < tickets.length; i++) {
        if (!visited[i] && tickets[i][0].equals(u)) {
            visited[i] = true;
            dfs(tickets, tickets[i][1], visited, depth + 1, n);
            visited[i] = false;
        }
    }
    if (depth >= n - 1) {
        flag = true;
        return ;
    }
}
```

본 문제에서 주의할 점은, 한 번의 DFS를 통해 정답을 구할 수 없는 경우가 존재한다는 것이다. 해당 경로가 모든 항공권을 사용하지 않았을 수 있기 때문이다.

## 시간 복잡도

이번 문제에 대해 정확한 시간 복잡도를 파악하지 못했다. 주어진 그래프에 따라 백트래킹이 걸리는 시간이 달라지기 때문에, 어떻게 시간 복잡도를 구할지 모르겠다...