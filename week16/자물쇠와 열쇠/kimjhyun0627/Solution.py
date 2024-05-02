def solution(key, lock):

    def rotate(key, d):
        result = [[0 for _ in range(len(key))] for _ in range(len(key))]

        if d % 4 == 1:
            for r in range(len(key)):
                for c in range(len(key)):
                    result[c][len(key)-r-1] = key[r][c]
        elif d % 4 == 2:
            for r in range(len(key)):
                for c in range(len(key)):
                    result[len(key)-r-1][len(key)-c-1] = key[r][c]
        elif d % 4 == 3:
            for r in range(len(key)):
                for c in range(len(key)):
                    result[len(key)-c-1][r] = key[r][c]
        else:
            for r in range(len(key)):
                for c in range(len(key)):
                    result[r][c] = key[r][c]                

        return result

    def check(lock):
        l = len(lock) // 3
        for ii in range(l, l*2):
            for jj in range(l, l*2):
                if lock[ii][jj] != 1:
                    return False
        return True

    answer = False
    locks = [[0 for _ in range(len(lock)*3)] for _ in range(len(lock)*3)]

    for ii in range(len(lock)):
        for jj in range(len(lock)):
            locks[len(lock)+ii][len(lock)+jj] = lock[ii][jj]
        
    for ii in range(1, len(lock)*2):
        for jj in range(1, len(lock)*2):
            for deg in range(4):
                cur = rotate(key, deg)
                for x in range(len(key)):
                    for y in range(len(key)):
                        locks[ii+x][jj+y] += cur[x][y]
                         
                if check(locks):
                    return True
                
                for x in range(len(key)):
                    for y in range(len(key)):
                            locks[ii+x][jj+y] -= cur[x][y]

    return answer
