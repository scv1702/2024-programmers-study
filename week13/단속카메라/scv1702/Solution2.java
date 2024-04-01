import java.util.*;

class Solution {
    
    public int solution(int[][] routes) {
        int answer = 0;
    
        Arrays.sort(routes, (r1, r2) -> r1[1] - r2[1]);
        
        int c = Integer.MIN_VALUE;
        for (int[] r: routes) {
            if (c < r[0]) {
                answer += 1;
                c = r[1];
            }
        }
        
        return answer;
    }
}