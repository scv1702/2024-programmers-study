import java.util.*;

class Solution {
    public void union(int[] parent, int u, int v) {
        int a = find(parent, u);
        int b = find(parent, v);  
        parent[Math.max(a, b)] = Math.min(a, b);
    }
    
    public int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }
    
    public int solution(int n, int[][] costs) {
        // union-find to detect cycle
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        // sort by weight
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);
        
        // do kruskal algorithm
        int answer = 0;
        for (int i = 0, cnt = 0; i < costs.length && cnt < n - 1; i++) {
            int[] cost = costs[i];
            int u = cost[0];
            int v = cost[1];
            int w = cost[2];
            
            // u-v edge must not make a cycle
            if (find(parent, u) != find(parent, v)) {
                union(parent, u, v);
                cnt += 1;
                answer += w;
            }
        }
        
        return answer;
    }
}