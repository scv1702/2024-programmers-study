import java.util.*;

class Solution {
    
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] ps = new long[n + 1];
        
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i-1] + (sequence[i-1] * (i % 2 == 0 ? -1 : 1));
        }
        
        long answer = Long.MIN_VALUE;
        long pm = 0;
        long mm = 0;
        
        for (int i = 1; i <= n; i++) { 
            answer = Math.max(answer, Math.max(ps[i] - pm, -ps[i] - mm));
            pm = Math.min(pm, ps[i]);
            mm = Math.min(mm, -ps[i]);
        }
        
        return answer;
    }
}