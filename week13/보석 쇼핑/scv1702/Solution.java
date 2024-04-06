import java.util.*;

class Solution {
    
    public void init(Map<String, Integer> bag, Set<String> category) {
        for (String gem: category) {
            bag.put(gem, 0);
        }
    }
    
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = Integer.MAX_VALUE;
        
        Set<String> category = new HashSet<>();
        for (String gem: gems) {
            category.add(gem);
        }
        
        Map<String, Integer> gemCnts = new HashMap<>();
        init(gemCnts, category);
        Set<String> gemSet = new HashSet<>();
        
        for (int i = 0, j = 0; j < gems.length;) {   
            while (gemSet.size() != category.size() && j < gems.length) {
                gemCnts.put(gems[j], gemCnts.get(gems[j]) + 1);
                gemSet.add(gems[j]);
                j += 1;
            }
            if (gemSet.size() != category.size()) {
                break;
            }
            while (i < j) {
                String gem = gems[i++];
                gemCnts.put(gem, gemCnts.get(gem) - 1);
                if (gemCnts.get(gem) < 1) {
                    gemSet.remove(gem);
                    break;
                }
            }
            if (answer[1] - answer[0] > j - i) {
                answer[0] = i;
                answer[1] = j;
            }
        }
        
        return answer;
    }
}