def solution(board, skill):

    n = len(board)
    m = len(board[0])
    imos = [[0 for _ in range(m+1)] for _ in range(n+1)]
    
    for type, r1, c1, r2, c2, degree in skill:
        degree = -degree if type == 1 else degree
        imos[r1][c1] += degree
        imos[r2+1][c1] -= degree
        imos[r1][c2+1] -= degree
        imos[r2+1][c2+1] += degree
    
    for row in range(n+1):
        for col in range(1, m+1):
            imos[row][col] += imos[row][col-1]
        
    for col in range(m+1):
        for row in range(1, n+1):
            imos[row][col] += imos[row-1][col]
        
    answer = 0
    for row in range(n):
        for col in range(m):
            if board[row][col] + imos[row][col] > 0:
                answer += 1

    return answer
