import java.util.*;

class Solution {
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> enrollIds = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            enrollIds.put(enroll[i], i);
        }
        
        for (int i = 0; i < seller.length; i++) {
            int revenue = 100 * amount[i];
            String enr = enroll[enrollIds.get(seller[i])];
            String ref = referral[enrollIds.get(seller[i])];
            while (!enr.equals("-") && revenue > 0) {
                int tax = revenue / 10;
                answer[enrollIds.get(enr)] += revenue - tax;
                revenue = tax;
                int refIdx = enrollIds.getOrDefault(ref, -1);
                enr = ref;
                ref = refIdx >= 0 ? referral[refIdx] : "-";
            }
        }
        
        return answer;
    }
}