def solution(scores):

    target = scores[0]
    scores.sort(key=lambda x: (-x[0], x[1]))

    answer = 1
    m = 0
    for s in scores:
        if target[0] < s[0] and target[1] < s[1]:
            answer = -1
            break
        if m <= s[1]:
            if sum(target) < s[0] + s[1]:
                answer += 1
            m = s[1]
    
    return answer
