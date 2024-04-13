import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // construct the grpah
        boolean[][] graph = new boolean[n][n];
        
        for (int[] e: edge) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            graph[u][v] = true;
            graph[v][u] = true;
        }
        
        // do bfs
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            boolean isNotTerminalNode = false;
            for (int next = 0; next < n; next++) {
                if (graph[node][next] && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    isNotTerminalNode = true;
                }
            }
            if (isNotTerminalNode) {
                answer += 1;
            }
        }

        return answer;
    }
}