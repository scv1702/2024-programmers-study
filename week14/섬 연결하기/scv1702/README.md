# 문제 풀이

## 문제 해설

본 문제는 주어진 그래프의 MST(Minimum Spanning Tree)에서 total weight를 구하면 된다. MST를 구하는 방법에는 kruskal 알고리즘과 prim 알고리즘이 있는데 kruskal 알고리즘은 간선을 기준으로, prim 알고리즘은 정점을 기준으로 MST를 탐색한다. 주어진 그래프가 간선이 적은 sparse graph인 경우 kruskal 알고리즘이 유리하고, 간선이 많은 dense graph인 경우 prim 알고리즘이 유리하다. 필자는 kruskal 알고리즘을 이용해 본 문제를 해결했다.

kruskal 알고리즘은 다음과 같은 절차로 이루어진다.

1. 그래프의 간선들을 가중치에 대해 오름차순으로 정렬한다.
2. 정렬된 간선들을 순차적으로 탐색하면서, MST의 간선으로 선택한다. 이때 선택한 간선은 MST에 추가 됐을때 cycle을 생성하면 안된다. cycle을 생성하는 경우, 해당 간선은 무시한다.
3. 정점의 개수를 $V$이라고 할 때, 간선을 $V-1$개 선택할 때까지 반복한다. 정점이 $n$개 일 때 cycle을 생성하지 않으며 모든 정점을 연결하는 최소 간선 수가 $V-1$이기 때문이다.

cycle을 탐지 여부는 union-find 알고리즘을 통해 수행할 수 있다. union-find 알고리즘은 disjoint-set을 저장하는 자료구조로 두 disjoint-set을 하나의 set으로 합치는 `union()`과 set에 속한 각 원소들의 parent를 찾는 `find()`이 있다. 처음에는 각 원소 `i`의 parent를 `i`로 초기화, 즉 `parent[i] = i`에서 시작한다. 

## 시간 복잡도

간선 개수를 $E$, 정점 개수를 $V$라고 할 때 $O(E\log{E} + E\log{V})$이다. 간선을 정렬하는데 $O(E\log{E})$가 걸리는 것은 자명하다. 간선들을 순차적으로 탐색하는 과정에서 `union()`과 `find()`를 수행하는데, 탐색하는 tree가 balanced tree인 경우 $O(\log{V})$가 걸린다. 그러나 보통 $V << E$이기 때문에 $O(E\log{E} + E\log{V})$는 $O(E\log{E})$라고 할 수 있다.