import java.util.*;

class Solution {
    private static final int NULL = 2501;
    
    public int solve(String s, int i, int j, int[][] mem) {
        if (i < 0 || i >= s.length() || j < 0 || j >= s.length() || i > j) {
            return 0;
        }
        if (mem[i][j] != NULL) {
            return mem[i][j];
        }
        if (i == j) {
            mem[i][j] = 1;
            return 1;
        }
        if (s.charAt(i) != s.charAt(j)) {
            mem[i][j] = -1;
            return -1;
        }
        int res = solve(s, i + 1, j - 1, mem);
        if (res == -1) {
            mem[i][j] = -1;
            return -1;
        }
        mem[i][j] = res + 2;
        return res + 2;
    }
    
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        int[][] mem = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(mem[i], NULL);
            mem[i][i] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, solve(s, i, j, mem));
            }
        }
        
        return answer;
    }
}