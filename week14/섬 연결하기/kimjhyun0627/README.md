  # 문제 풀이

## 문제 해설

***kruskal***

*집합 이용하기*

1. costs list를 cost 크기 순으로 sort한다.
2. cost가 가장 짧은 vertex를 set에 append한다.
3. kruskal 알고리즘을 이용한다. set에 모든 vertex가 들어갈 때까지 순회하며 costs의 원소 중 두 vertex 중 하나라도 set에 들어가있지 않은 경우 set을 update하고 answer에 cost 크기만큼을 더해준다.
4. answer를 반환한다.

## 시간 복잡도

$$O(costs*len(vertex))$$

