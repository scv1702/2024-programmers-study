import java.util.*;

class Solution {

    public int solution(int[][] jobs) {
        // (작업 소요 시간, 작업 요청 시점)에 대해 정렬
        PriorityQueue<int[]> jq = new PriorityQueue<>((j1, j2) -> {
            if (j1[1] == j2[1]) {
                return j1[0] - j2[0];
            }
            return j1[1] - j2[1];
        });

        // (작업 요청 시점, 작업 소요 시간)에 대해 정렬
        Arrays.sort(jobs, (j1, j2) -> { 
            if (j1[0] == j2[0]) {
                return j1[1] - j2[1];
            }
            return j1[0] - j2[0];
        });
        
        int t = 0; // 현재 시간
        int i = 0; // 작업 인덱스
        int j = 0; // 실행 완료한 작업 수
        int answer = 0;
        
        while (j < jobs.length) {
            // 현재 시간보다 같거나 이전인 작업들을 작업 큐에 추가
            for (; i < jobs.length && jobs[i][0] <= t; i++) {
                jq.offer(jobs[i]);
            }
            
            // 실행할 작업 탐색
            if (!jq.isEmpty()) {
                int[] process = jq.poll();
                answer += (t - process[0]) + process[1];
                t += process[1];
                j += 1;
            } else {
                t = jobs[i][0];
            }
        }
        
        return answer / jobs.length;
    }
}