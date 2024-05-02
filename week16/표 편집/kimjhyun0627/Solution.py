def solution(n, k, cmd):

    pos = k
    table = {ii: [ii-1, ii+1] for ii in range(n)}
    answer = ['O' for _ in range(n)]
    table[0] = [None, 1]
    table[n-1] = [n-2, None]
    stack = []

    for c in cmd:
        if c == "C":
            answer[pos] = 'X'
            prev, next = table[pos]
            stack.append([prev, pos, next])

            if next == None:
                pos = table[pos][0]
            else:
                pos = table[pos][1]

            if prev == None:
                table[next][0] = None
            elif next == None:
                table[prev][1] = None
            else:
                table[prev][1] = next
                table[next][0] = prev

        elif c == "Z":
            prev, cur, next = stack.pop()
            answer[cur] = 'O'

            if prev == None:
                table[next][0] = cur
            elif next == None:
                table[prev][1] = cur
            else:
                table[next][0] = cur
                table[prev][1] = cur

        else:
            dir, deg = c.split(' ')
            deg = int(deg)
            
            if dir == 'D':
                for _ in range(deg):
                    pos = table[pos][1]
            else:
                for _ in range(deg):
                    pos = table[pos][0]

    return ''.join(answer)
