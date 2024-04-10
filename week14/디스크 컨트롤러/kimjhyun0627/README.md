  # 문제 풀이

## 문제 해설

***heap***

*그리디일줄 알았는데 그리디도 아닌 약간 애매한…*
	
1. heapify를 통해 jobs를 heap으로 만든다.
2. while문을 순회하며 현재 time에 가능한 job들을 hq에 넣는다. hq가 비어있지 않다면 answer에 duration을 추가해주고 time += duration 해준다.
3. hq에 남은 프로세스들을 대상으로 순회하며 answer에 duration을 추가하고 time을 늘린다.
4. 몫을 버림해 반환한다.

## 시간 복잡도

$$O(jobs*log(jobs))$$

