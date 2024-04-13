  # 문제 풀이

## 문제 해설

***DFS***

*레벨 3 오고 시간복잡도에 미쳐서 단순한 문제도 이상하게 쳐다보게 됨*
*처음에 짰던 개쩐다고 생각했던 코드*
```python
from collections import defaultdict
import heapq

def solution(tickets):
	ticket_dict = defaultdict(list)
	for t in tickets:
	heapq.heappush(ticket_dict[t[0][0]], t)
	
	cur = 'ICN’
	answer = ['ICN']
	while True:
		if len(ticket_dict[cur[0]]) == 0:
			break
		flight = heapq.heappop(ticket_dict[cur[0]])
		cur = flight[1]
		answer.append(flight[1])
	
	return  answer
```
*현실은 어림도 없지 ㅋㅋ*
*그래도 defaultdict랑 heapq 같이 쓰니까 편하다는걸 알았으니까…*
	
	
1. defaultdict와 heapq를 이용해 그래프의 edge dictionary를 만든다.
2. dfs 순회한다. 스택을 이용하여 알파벳순으로 깊이 우선 탐색하며 전체 경로를 순회한다.
3. answer를 뒤집어 반환한다.

## 시간 복잡도

$$O(tickets*log(tickets))$$

