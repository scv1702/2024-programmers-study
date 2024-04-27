from collections import defaultdict
from collections import deque

def solution(n: int, roads: list, sources: list, destination: int):

    graph = defaultdict(list)

    for r1, r2 in roads:
        graph[r1].append(r2)
        graph[r2].append(r1)

    dist = [-1 for _ in range(n+1)]
    visited = [False for _ in range(n+1)]
    queue = deque()
    queue.append([destination, 0])

    while queue:
        v, l = queue.popleft()
        if visited[v]:
            continue
        
        visited[v] = True
        dist[v] = l

        for g in graph[v]:
            queue.append([g, l+1])

    answer = []
    for s in sources:
        answer.append(dist[s])
    
    return answer
