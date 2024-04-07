from collections import deque

def solution(n, edge):
    
    graph = {ii:[] for ii in range(1, n+1)}
    for e in edge:
        graph[e[0]].append(e[1])
        graph[e[1]].append(e[0])
         
    queue = deque([])
    distance = [1e9 for _ in range(n+1)]
    distance[1] = 0
    queue.append(1)
    
    while queue:
        cur = queue.popleft()
        for g in graph[cur]:
            if distance[g] == 1e9:
                distance[g] = distance[cur] + 1
                queue.append(g)
    
    answer = distance[1:].count(max(distance[1:]))
    return answer
