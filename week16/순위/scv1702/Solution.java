class Solution {
    private int answer = 0;
    
    public void dfs(int[][] graph, boolean[] visited, int node) {
        int n = graph.length;
        visited[node] = true;
        
        for (int next = 0; next < n; next++) {
            if (graph[node][next] == 1 && !visited[next]) {
                dfs(graph, visited, next);
            }
        }
    }
    
    public int solution(int n, int[][] results) {
        int[][] win = new int[n][n];
        int[][] lose = new int[n][n];
        
        for (int[] result: results) {
            win[result[0] - 1][result[1] - 1] = 1;
            lose[result[1] - 1][result[0] - 1] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(win, visited, i);
            visited[i] = false;
            dfs(lose, visited, i);
            int s = 0;
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    s += 1;
                }
            }
            if (s == n) {
                answer += 1;
            }
        }
        
        return answer;
    }
}