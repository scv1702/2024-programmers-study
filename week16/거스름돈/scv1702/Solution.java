class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int solution(int n, int[] money) {
        int answer = 0;
        int m = money.length;
        int[] mem = new int[n + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = money[i]; j <= n; j++) {
                mem[j] += (mem[j - money[i]]) % MOD;
                if (j == money[i]) {
                    mem[j] += (1 % MOD);
                }
            }
        }
        
        return mem[n] % MOD;
    }
}