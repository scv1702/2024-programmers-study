from itertools import combinations
from collections import Counter

def solution(orders, course):

    lst = []
    for o in orders:
        for c in course:
            lst += list(combinations(sorted(o), c))

    c = Counter([''.join(l) for l in lst])
    d = {c: [2] for c in course}
    for k, v in c.items():
        if d[len(k)][0] > v:
            continue
        elif d[len(k)][0] < v:
            d[len(k)] = [v, k]
        else:
            d[len(k)].append(k)

    answer = []
    for v in d.values():
        answer += v[1:]
    return sorted(answer)

print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2,3,4]))
print(solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2,3,5]))
print(solution(["XYZ", "XWY", "WXA"], [2,3,4]))