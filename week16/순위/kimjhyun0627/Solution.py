def solution(n, results):

    rounds = [[0 for _ in range(n+1)] for _ in range(n+1)]
    for a, b in results:
        rounds[a][b] = 1
    
    for kk in range(1, n+1):
        for ii in range(1, n+1):
            for jj in range(1, n+1):
                if rounds[ii][jj] == 0 and rounds[ii][kk] == 1 and rounds[kk][jj] == 1:
                    rounds[ii][jj] = 1
    
    played = [0 for _ in range(n+1)]
    for ii in range(1, n+1):
        for jj in range(1, n+1):
            if rounds[ii][jj] == 1:
                played[ii] += 1
                played[jj] += 1

    answer = 0                
    for ii in range(1, n+1):
        if played[ii] == n-1:
            answer += 1

    return answer
