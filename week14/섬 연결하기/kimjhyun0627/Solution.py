def solution(n, costs):
    
    costs.sort(key=lambda x: x[2])
    linked = set([costs[0][0]])
    
    answer = 0
    while len(linked) != n:
        for c in costs:
            if c[0] in linked and c[1] in linked:
                continue
            if c[0] in linked or c[1] in linked:
                linked.update([c[0], c[1]])
                answer += c[2]
                break
            
    return answer
