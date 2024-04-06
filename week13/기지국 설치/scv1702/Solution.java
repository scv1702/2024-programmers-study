class Solution {
    
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int apart = 1;
        
        for (int station: stations) {
            if (apart < (station - w)) {
                answer += (station - w - apart) / (2 * w + 1);
                if ((station - w - apart) % (2 * w + 1) != 0) {
                    answer += 1;
                }
            }
            apart = station + w + 1;
        }
        
        if (apart <= n) {
            answer += (n + 1 - apart) / (2 * w + 1);
            if ((n + 1 - apart) % (2 * w + 1) != 0) {
                answer += 1;
            }
        }

        return answer;
    }
}