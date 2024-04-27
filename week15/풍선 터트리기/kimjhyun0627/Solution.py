def solution(a):

    def check(arr):
        s = []
        min_b = 1000000001
        for a in arr:
            if min_b > a:
                min_b = a
                s.append(a)
        return s

    survived = set(check(a) + check(a[::-1]))

    answer = len(survived)
    return answer
