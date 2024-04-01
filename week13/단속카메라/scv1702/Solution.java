import java.util.*;

class Solution {
    class Range {
        int s;
        int e;
        
        Range(int s, int e) {
            this.s = s;
            this.e = e;
        }
        
        boolean contains(int n) {
            return s <= n && n <= e;
        }
        
        @Override
        public boolean equals(Object o) {
            Range r = (Range) o;
            return r.s == this.s && r.e == this.e;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(s, e);
        }
        
        @Override
        public String toString() {
            return String.format("[%d, %d]", s, e);
        }
    }
    
    public int solution(int[][] routes) {
        int answer = 0;
        Map<Range, Boolean> checked = new HashMap<>();
        Range[] rs = new Range[routes.length];
        
        for (int i = 0; i < routes.length; i++) {
            Range range = new Range(routes[i][0], routes[i][1]);
            checked.put(range, false);
            rs[i] = range;
        }
        
        Arrays.sort(rs, (r1, r2) -> r1.e - r2.e);
        
        for (int i = 0; i < rs.length; i++) {
            Range r1 = rs[i];
            if (checked.get(r1)) {
                continue;
            }
            boolean flag = false;
            for (int j = i; j < rs.length; j++) {
                Range r2 = rs[j];
                if (!checked.get(r2) && r2.contains(r1.e)) {
                    checked.put(r2, true);
                    flag = true;
                }
            }
            if (flag) {
                answer += 1;
            }
        }
        
        return answer;
    }
}