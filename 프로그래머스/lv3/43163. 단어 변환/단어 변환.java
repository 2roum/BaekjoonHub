class Solution {
    static int ans = 100;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, visited, words, target, 0);
        if (ans == 100)
            return 0;
        else
            return ans;
    }
    public void dfs(String start, boolean[] visited, String[] words, String target, int cnt){
        if (start.equals(target)){
            if (ans > cnt) {
                ans = cnt;
            }
            return ;
        }
        for (int i = 0 ; i < visited.length ; i++){
            if (!visited[i] && check(start, words[i])){
                visited[i] = true;
                dfs(words[i], visited, words, target, cnt + 1);
                visited[i] = false;
            }
        }
    }
    public boolean check(String word1, String word2){
        int cnt = 0;
        for (int i = 0 ; i < word1.length() ; i++){
            if (word1.charAt(i) != word2.charAt(i))
                cnt++;
        }
        return cnt == 1;
    }
}