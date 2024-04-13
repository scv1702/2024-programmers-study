import java.util.*;

class Solution {
    static int[][] dirs = {
        {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };

    public int dotp(int d1, int d2) {
        int[] v1 = dirs[d1];
        int[] v2 = dirs[d2];
        return v1[0] * v2[0] + v1[1] * v2[1];
    }
    
    public boolean validate(int[][] board, int r, int c) {
        int n = board.length;
        return r >= 0 && r < n && c >= 0 && c < n && board[r][c] == 0;
    }
    
    public int solution(int[][] board) {
        int n = board.length;
        int answer = Integer.MAX_VALUE;
        int[][] costs = new int[n * n][dirs.length];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] { 0, -1, 0 });
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            int pos = cur[0];
            int d = cur[1];
            int cost = cur[2];
            
            int r = pos / n;
            int c = pos % n;
            
            if (r == n - 1 && c == n - 1) {
                answer = Math.min(answer, cost);
                continue;
            }

            for (int nd = 0; nd < dirs.length; nd++) {
                int nr = r + dirs[nd][0];
                int nc = c + dirs[nd][1];
                if (!validate(board, nr, nc)) continue;
                int npos = nr * n + nc;
                int ncost = 100;
                if (d >= 0) {
                    ncost += cost + (dotp(d, nd) == 0 ? 500 : 0);
                }
                if (costs[npos][nd] == 0 || ncost < costs[npos][nd]) {
                    costs[npos][nd] = ncost;
                    queue.offer(new int[] { npos, nd, ncost });
                }
            }
        }

        return answer;
    }
}