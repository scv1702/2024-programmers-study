import java.util.*;

class Solution {
    class Sing {
        int num;
        int play;
        
        Sing(int num, int play) {
            this.num = num;
            this.play = play;
        }
        
        @Override
        public String toString() {
            return String.format("[num=%d, play=%d]", num, play);
        }
    }
    
    class Genre {
        String name;
        int play;
        
        Genre(String name, int play) {
            this.name = name;
            this.play = play;
        }
        
        @Override
        public String toString() {
            return String.format("[name=%s, play=%d]", name, play);
        }
    }
    
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, List<Sing>> singMap = new HashMap<>();
        Map<String, Integer> singCounts = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            Sing sing = new Sing(i, plays[i]);
            singCounts.put(genres[i], singCounts.getOrDefault(genres[i], 0) + sing.play);
            List<Sing> sings = singMap.getOrDefault(
                genres[i], 
                new ArrayList<>()             
            );
            sings.add(sing);
            singMap.put(genres[i], sings);
        }
        
        PriorityQueue<Genre> genrePQ = new PriorityQueue<>((g1, g2) -> g2.play - g1.play);
        singCounts.forEach((name, play) -> genrePQ.offer(new Genre(name, play)));
        
        while (!genrePQ.isEmpty()) {
            Genre genre = genrePQ.poll();
            List<Sing> sings = singMap.get(genre.name);
            sings.sort((s1, s2) -> {
                if (s1.play == s2.play) {
                    return s1.num - s2.num;
                }
                return s2.play - s1.play;
            });
            int m = Math.min(sings.size(), 2);
            for (int i = 0; i < m; i++) {
                answer.add(sings.get(i).num);
            }
        }
        
        return answer;
    }
}