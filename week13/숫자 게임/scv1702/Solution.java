import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int n = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B); 
        
        int j = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (A[i] < B[j]) {
                answer += 1;
                j -= 1;
            }
        }
        
        return answer;
    }
}