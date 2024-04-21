import java.util.*;

class Solution {
    public String toString(int time) {
        return String.format("%02d", time / 60) + ":" + String.format("%02d", time % 60);
    }
    
    public int toMinute(String time) {
        String[] splited = time.split(":");
        return Integer.parseInt(splited[0]) * 60 + Integer.parseInt(splited[1]);
    }
    
    // return index if num is in array else (insertion point - 1)
    public int search(int[] array, int num) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] <= num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
    
    // insert num at array[idx]
    public int[] insert(int[] array, int idx, int num) {
        int[] res = new int[array.length + 1];
        for (int i = 0; i < idx; i++) {
            res[i] = array[i];
        }
        res[idx] = num;
        for (int i = idx; i < array.length; i++) {
            res[i + 1] = array[i];
        }
        return res;
    }
    
    public boolean validate(int[] times, int n, int t, int m, int idx) {
        int last = toMinute("09:00") + (n - 1) * t;
        int i = 0;
        int j = 0;
        
        for (int time = toMinute("09:00"); time <= last; time += t) {
            for (; j < times.length && j < i + m && times[j] <= time; j++) {
                continue;
            }
            if (idx < j) {
                return true;
            }
            if (idx == j && j - i + 1 <= m) {
                return true;  
            }
            i = j;
        }
        
        return false;
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        int[] times = Arrays.stream(timetable)
            .mapToInt((time) -> toMinute(time))
            .sorted()
            .toArray();
        int min = times[0];
        int max = times[times.length - 1];
        int last = toMinute("09:00") + (n - 1) * t;

        for (int ans = last; ans >= 0; ans--) {
            int idx = search(times, ans);
            int[] res = insert(times, idx + 1, ans);
            if (validate(res, n, t, m, idx + 1)) {
                return toString(ans);
            }
        }
        
        return toString(0);
    }
}