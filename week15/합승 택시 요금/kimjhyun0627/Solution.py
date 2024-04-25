def solution(n, s, a, b, fares):

    INF = 1000001 * n
    answer = INF

    graph = [[INF for _ in range(n+1)] for _ in range(n+1)]

    for start, end, f in fares:
        graph[start][end] = f
        graph[end][start] = f
    
    for ii in range(n+1):
        for jj in range(n+1):
            for kk in range(n+1):
                            graph[jj][kk] = min(graph[jj][kk], graph[jj][ii]+graph[ii][kk])

    for ii in range(1, n+1):
          graph[ii][ii] = 0

        
    for ii in range(1, n+1):
          answer = min(answer, graph[s][ii]+graph[ii][a]+graph[ii][b])

    return answer
