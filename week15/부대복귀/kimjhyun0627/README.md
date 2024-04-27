  # 문제 풀이

## 문제 해설

***dfs***


1. defaultdict를 이용해 graph를 재구성한다.
2. dist 정보와 visited 정보를 담을 list를 정의한다. 이후 queue를 정의하고 [목적지, 0(거리)]를 append해준다.
3. dfs 순회한다. queue가 빌때 까지 popleft하고 아직 방문하지 않은 노드에 대해 방문 처리와 함께 거리를 입력해준다. 어차피 간선의 길이는 모두 1로 같으므로 대소 비교가 필요없다.
4. sources에 대해 목적지로부터의 거리를 append해주고 반환한다.

## 시간 복잡도

$$O(sources*log(sources))$$

