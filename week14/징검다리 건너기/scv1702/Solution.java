import java.util.*;

class Solution {
    
    public int max(int[] array) {
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            if (res < array[i]) {
                res = array[i];
            }
        }
        return res;
    }
    
    public int min(int[] array) {
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            if (res > array[i]) {
                res = array[i];
            }
        }
        return res;
    }
    
    public int solution(int[] stones, int k) {
        int n = stones.length;
        int maxf = max(stones);
        int minf = min(stones);

        while (minf <= maxf) {
            // stones를 midf명이 건널 수 있는가?
            int midf = (maxf + minf) / 2;
            int c = 0;
            for (int i = 0; i < n && c < k; i++) {
                if (midf > stones[i]) {
                    c += 1;
                } else {
                    c = 0;
                }
            }
            if (c < k) { // 건널 수 있는 경우
                minf = midf + 1;
            } else { // 건널 수 없는 경우
                maxf = midf - 1;
            }
        }
        
        return maxf;
    }
}