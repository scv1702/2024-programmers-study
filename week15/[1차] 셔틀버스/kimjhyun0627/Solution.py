from collections import deque

def solution(n, t, m, timetable):

    table = sorted([int(t.split(":")[0]) * 60 + int(t.split(":")[1]) for t in timetable])
    table = deque(table)

    last = table[0] - 1
    for ii in range(n):
        arrive = 540 + t * ii
        for _ in range(m):
            if not table:
                last = arrive
                break
            if table[0] <= arrive:
                last = table.popleft() - 1
            else:
                last = arrive

    answer = f'{last//60:02d}:{last%60:02d}'
    return answer
