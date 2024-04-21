import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road: roads) {
            int u = road[0] - 1;
            int v = road[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        
        visited[destination - 1] = true;
        queue.offer(new int[] { destination - 1, 0 });
        
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0];
            int distance = pair[1];
            
            dist[node] = distance;
            
            for (int next: graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[] { next, distance + 1 });
                }
            }
        }
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i] - 1];            
        }
        
        return answer;
    }
}