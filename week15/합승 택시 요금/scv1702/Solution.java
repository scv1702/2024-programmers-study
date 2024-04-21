import java.util.*;

class Solution {
    
    public int[] dijkstra(int start, int[][] graph) {
        int n = graph.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        int[] dist = new int[n];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[start] = 0; 
        pq.offer(new int[] { start, 0 });
        
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int node = pair[0];
            int distance = pair[1];
            if (dist[node] < distance) continue;
            for (int next = 1; next < n; next++) {
                if (graph[node][next] <= 0) continue;
                int nextDistance = distance + graph[node][next];
                if (nextDistance < dist[next]) {
                    dist[next] = nextDistance;
                    pq.offer(new int[] { next, nextDistance });
                }
            }
        }
        
        return dist;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n + 1][n + 1];
        
        for (int[] edge: fares) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u][v] = graph[v][u] = w;
        }
        
        int[] S = dijkstra(s, graph);
        int[] A = dijkstra(a, graph);
        int[] B = dijkstra(b, graph);
        
        int answer = S[a] + S[b];
        
        for (int i = 1; i <= n; i++) {
            int distA = A[i];
            int distB = B[i];
            if (distA < Integer.MAX_VALUE && distB < Integer.MAX_VALUE) {
                answer = Math.min(answer, S[i] + A[i] + B[i]);
            }
        }
        
        return answer;
    }
}