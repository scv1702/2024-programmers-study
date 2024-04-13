def solution(stones, k):
    
    answer = 0
    start, end = 1, max(stones)
    
    while start <= end:
        cnt = 0
        mid = (start + end) // 2
        
        for s in stones:
            if s - mid <= 0:
                cnt += 1
                if cnt >= k:
                    break
            else:
                cnt = 0
        
        if cnt >= k:
            end = mid - 1
        else:
            start = mid + 1
            answer = start
    
    return answer
