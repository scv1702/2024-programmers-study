class Solution {
    int MOD = 20170805;
    int LEFT = 0;
    int UP = 1;
    
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] mem = new int[m][n][2];
        
        for (int j = 0; j < n && cityMap[0][j] != 1; j++) {
            mem[0][j][LEFT] = 1;
        }
        
        for (int i = 0; i < m && cityMap[i][0] != 1; i++) {
            mem[i][0][UP] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == 1) continue;
                mem[i][j][UP] = mem[i-1][j][UP];
                mem[i][j][LEFT] = mem[i][j-1][LEFT];
                if (cityMap[i-1][j] == 0) {
                    mem[i][j][UP] = (mem[i][j][UP] + mem[i-1][j][LEFT]) % MOD;
                }
                if (cityMap[i][j-1] == 0) {
                    mem[i][j][LEFT] = (mem[i][j][LEFT] + mem[i][j-1][UP]) % MOD;
                }
            }
        }
        
        return (mem[m-1][n-1][LEFT] + mem[m-1][n-1][UP]) % MOD;
    }
}