class Solution {
    public long pow(long a, long b) {
        long res = 1;
        for (int i = 0; i < b; i++) {
            res *= a;
        }
        return res;
    }
    
    public long solution(int n, int[] times) {
        long start = 1;
        long end = pow(10, 18);
        
        while (start <= end) {
            long mid = (start + end) / 2;
            long tp = 0;
            for (int time: times) {
                tp += mid / time;
            }
            if (tp < n) {
                start = mid + 1;
            } else { 
                end = mid - 1;
            }
        }
        
        return start;
    }
}