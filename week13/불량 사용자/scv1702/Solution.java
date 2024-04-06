import java.util.*;

class Solution {
    
    String[] result; // combination result
    String[] uids; // user_id
    String[] bids; // banned_id
    int answer;
    int m;
    
    // return true if uid can be banned
    public boolean validate(String uid, String bid) {
        if (uid.length() != bid.length()) {
            return false;
        }
        for (int i = 0; i < bid.length(); i++) {
            if (bid.charAt(i) != '*') {
                if (bid.charAt(i) != uid.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    boolean flag = false;
    
    public void permutation(boolean[] visited, int r, int depth) {
        if (flag) {
            return ;
        }
        if (depth >= r) {
            flag = true;
            return ;
        }
        for (int i = 0; i < m; i++) {
            if (!visited[i] && validate(result[depth], bids[i])) {
                visited[i] = true;
                permutation(visited, r, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public void combination(int n, int r, int prev, int depth) {
        if (depth >= r) {
            for (String uid: result) {
                permutation(new boolean[m], m, 0);
                if (!flag) {
                    return ;
                }
            }
            flag = false;
            answer += 1;
            return ;
        }
        
        for (int i = prev; i < n; i++) {
            result[depth] = uids[i];
            combination(n, r, i + 1, depth + 1);
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        result = new String[banned_id.length];
        uids = user_id;
        bids = banned_id;
        m = banned_id.length;
        
        combination(user_id.length, m, 0, 0);
        
        return answer;
    }
}