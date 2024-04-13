def solution(n, times):
    
    min_t = 0
    max_t = max(times) * n
    answer = 0
    
    while min_t <= max_t:
        
        mid_t = (min_t + max_t) // 2
        passed = 0
        
        for t in times:
            passed += mid_t // t
            if passed >= n:
                break
            
        if passed >= n:
            answer = mid_t
            max_t = mid_t - 1
        else:
            min_t = mid_t + 1
            
    return answer
