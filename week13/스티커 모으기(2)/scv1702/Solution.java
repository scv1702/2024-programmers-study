import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        int answer = 0;
        int[] mem = new int[n];

        if (n <= 1) {
            return sticker[0];
        }

        // sticker[0]을 떼는 경우, stciker[n-1]은 뗄 수 없다.
        mem[0] = sticker[0];
        mem[1] = Math.max(mem[0], sticker[1]);
        for (int i = 2; i < n - 1; i++) {
            mem[i] = Math.max(mem[i-2] + sticker[i], mem[i-1]);
        }
        answer = mem[n-2];

        // sticker[0]을 떼지 않는 경우, stciker[n-1]은 뗄 수 있다.
        mem[0] = 0;
        mem[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            mem[i] = Math.max(mem[i-2] + sticker[i], mem[i-1]);
        }
        answer = Math.max(answer, mem[n-1]);

        return answer;
    }
}