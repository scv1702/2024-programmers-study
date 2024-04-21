import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int answer = n;
        int[] lm = new int[n];
        int[] rm = new int[n];
        int j = a[0];
        for (int i = 0; i < n; i++) {
            lm[i] = j = Math.min(j, a[i]);
        }
        int k = a[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            rm[i] = k = Math.min(k, a[i]);
        }
        for (int i = 0; i < n; i++) {
            if (lm[i] < a[i] && rm[i] < a[i]) {
                answer -= 1;
            }
        }
        return answer;
    }
}