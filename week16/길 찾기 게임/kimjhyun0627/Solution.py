from sys import setrecursionlimit
setrecursionlimit(1000000)

def solution(nodeinfo):

    info = sorted([[x, y, ii+1] for ii, (x, y) in enumerate(nodeinfo)], key=lambda x: x[0])
    answer = [[], []]

    def fix(info):
        if info:
            root = (0, -1, 0)
            for ii, (x, y, n) in enumerate(info):
                if y > root[1]:
                    root = (ii, y, n)
            answer[0].append(root[-1])
            left, right = info[:root[0]], info[root[0]+1:]
            fix(left)
            fix(right)
            answer[1].append(root[-1])

    fix(info)
    return answer
