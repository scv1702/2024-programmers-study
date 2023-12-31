# 문제 풀이

## 문제 해설
본 문제는 문자열 `s`가 주어질 경우 `s`를 보고 중복되는 원소가 없는 기존의 튜플 `t`를 역으로 계산하는 문제다. `s`는 `t[:i]`를 원소로 가지는 집합이다. 예를 들어, `t`가 `(2, 1, 3, 4)`인 경우 `s`는 `t[:1]`인 `{2}`, `t[:2]`인 `{2, 1}`, `t[:3]`인 `{2, 1, 3}`, `t[:4]`인 `{2, 1, 3, 4}`를 원소로 가져 `{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}`가 된다. 이때 집합은 원소의 순서가 상관이 없으므로 `{{2, 1, 3, 4}, {2, 1}, {2}, {2, 1, 3}}`도 논리적으로 같은 `s`가 되는 것이다. 또한 내부 순서가 바뀐 `{{2}, {1, 2}, {2, 1, 3}, {2, 1, 3, 4}}`도 논리적으로 `s`와 같다.

그렇다면, 어떻게 순서가 상관이 없는 자료 구조인 집합에서 순서과 중요한 자료 구조인 튜플을 알아낼 수 있을까? 여기서 필자는 `s`의 원소 중 가장 크기가 작은 `{2}`에 집중했다. `{2}`는 `t[:1]`에 대한 집합이다. 즉, `t[0]`이 바로 `2`라는 것이다. 그렇다면, `s`를 각 원소의 크기에 대해 정렬한다면 `t`의 원래 순서를 알 수 있지 않을까? `{{2, 1, 3, 4}, {2, 1}, {2}, {2, 1, 3}}`를 원소 크기에 대해 정렬하면, `{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}`가 된다. 이때 `2`는 `t[0]`임을 알고 있다. 이를 인지하면서 `s[1] = {2, 1}`을 보면, 이미 알고 있는 원소 `2`를 제외하고 남은 `1`이 `t[1]`이 된다. 이를 `s`의 모든 원소에 대해 반복하면 `t`를 알 수 있게 된다. 

## 시간 복잡도

아래 코드의 시간 복잡도는 `O(slog(s))`가 된다.

```java
class Solution {
    public int[] solution(String s) {
        Set<Integer> visited = new HashSet<>(); // 튜플의 모든 원소를 저장하는 집합. 원소 방문 시 해당 원소는 삭제된다.
        List<List<Integer>> setList = new ArrayList<>(); // s를 ArrayList로 변환한 자료구조
        
        // s를 parsing하여 ArrayList로 변환한다. O(s)
        int i = 1;
        while (i < s.length()) {
            List<Integer> set = new ArrayList<>();
            // s의 원소 하나를 StringBuilder에 담는다.
            StringBuilder sb = new StringBuilder();
            if (s.charAt(i) == '{') {
                i += 1;
                while (s.charAt(i) != '}') {
                    sb.append(s.charAt(i++));
                }
            }
            i += 2;
            StringTokenizer st = new StringTokenizer(sb.toString(), ",");
            while (st.hasMoreTokens()) {
                Integer e = Integer.parseInt(st.nextToken());
                set.add(e);
                visited.add(e);
            }
            setList.add(set);
        }
        
        // setList를 길이 순으로 정렬한다. O(slog(s))
        Collections.sort(setList, (List<Integer> s1, List<Integer> s2) -> s1.size() - s2.size());
        
        // 기존의 튜플을 계산한다. O(s)
        int[] answer = new int[visited.size()];
        int answerIdx = 0;
        for (List<Integer> set: setList) {
            for (Integer e: set) {
                if (visited.contains(e)) {
                    answer[answerIdx++] = e;
                    visited.remove(e);
                }
            }
        }
        
        return answer;
    }
}
```