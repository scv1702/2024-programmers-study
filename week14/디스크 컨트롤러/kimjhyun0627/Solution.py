import heapq

def solution(jobs):
    
    job_count = len(jobs)
    heapq.heapify(jobs)
    hq = []
    time = 0
    answer = 0
    
    while jobs:
        while jobs:
            start, duration = heapq.heappop(jobs)
            if start > time:
                heapq.heappush(jobs, [start, duration])
                break
            else:
                heapq.heappush(hq, [duration, start])
                
        if len(hq) == 0:
            time += 1
        else:
            duration, start = heapq.heappop(hq)
            answer += (duration + time - start)
            time += duration
    
    while hq:
        duration, start = heapq.heappop(hq)
        answer += duration + time - start
        time += duration
        
    answer //= job_count
    return answer

print(solution([[0, 3], [1, 9], [2, 6]]	))