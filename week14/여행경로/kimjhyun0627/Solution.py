from collections import defaultdict
import heapq

def solution(tickets):
    
    ticket_dict = defaultdict(list)
    
    for start, end in tickets:
        heapq.heappush(ticket_dict[start], end)
    
    answer = []
    path = ["ICN"]
    
    while path:
        now = path[-1]
        if now not in ticket_dict or len(ticket_dict[now]) == 0:
            answer.append(path.pop())
        else:
            path.append(heapq.heappop(ticket_dict[now]))
    
    return answer[::-1]