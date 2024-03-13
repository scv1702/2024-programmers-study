class Solution {

    static char [] friends;
    static String [] d;
    static int answer;
    static boolean [] visited;

    public static int solution(int n, String[] data) {

        d = data;
        answer = 0;
        friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        visited = new boolean[8];

        dfs("",0);
        return answer;
    }

    static void dfs(String line, int depth){

        if (depth == 8){
            if(check(line)) answer++;
            return;
        }

        for (int i = 0; i < 8; ++i){
            if (!visited[i]){
                visited[i] = true;
                dfs(line+friends[i], depth+1);
                visited[i] = false;
            }
        }
    }

    private static boolean check(String line){

        for (String cond : d){

            int diff = (Math.abs(line.indexOf(cond.charAt(0)) - line.indexOf(cond.charAt(2)))) - 1;
            char sign = cond.charAt(3);
            int val = cond.charAt(4) - '0';

            if (sign == '='){
                if (diff != val) return false;
            }
            else if (sign == '>'){
                if (diff <= val) return false;
            }
            else{
                if (diff >= val) return false;
            }
        }

        return true;
    }
}