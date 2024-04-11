import java.util.*;
import java.util.stream.*;

class Solution {
    
    String[] answer;
    boolean flag = false;
    
    public void dfs(
        String[][] tickets,
        String u,
        boolean[] visited,
        int depth,
        int n
    ) {
        if (flag) {
            return ;
        }
        answer[depth] = u;
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(u)) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], visited, depth + 1, n);
                visited[i] = false;
            }
        }
        if (depth >= n - 1) {
            flag = true;
            return ;
        }
    }
    
    public String[] solution(String[][] tickets) {
        int n = tickets.length + 1;
        boolean[] visited = new boolean[tickets.length];
        answer = new String[n];
        
        Arrays.sort(tickets, (t1, t2) -> t1[1].compareTo(t2[1]));
        
        dfs(tickets, "ICN", visited, 0, n);

        return answer;
    }
}