import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int n = scores.length;
        int[] me = scores[0];
        
        // 근무 태도 desc, 동료 평가 asc
        Arrays.sort(scores, (s1, s2) -> {
            if (s2[0] == s1[0]) {
                return s1[1] - s2[1];
            }
            return s2[0] - s1[0];
        });
    
        int max_b = scores[0][1]; // 동료 평가 최대값
        
        for (int i = 0; i < n; i++) {
            if (scores[i][1] < max_b) {
                if (scores[i] == me) return -1;
                scores[i] = null;
            } else {
                max_b = Math.max(max_b, scores[i][1]);
            }
        }
        
        scores = Arrays.stream(scores)
            .filter(score -> score != null)
            .toArray(int[][]::new);
        Arrays.sort(scores, (s1, s2) -> s2[0] + s2[1] - s1[0] - s1[1]);
        
        int s = scores[0][0] + scores[0][1];
        int c = 0;
        
        for (int i = 0; i < n; i++) {
            if (scores[i][0] + scores[i][1] == s) {
                c += 1;
            } else {
                answer += c;
                c = 1;
            }  
            if (scores[i] == me) {
                return answer;
            }
        }
        
        return -1;
    }
}