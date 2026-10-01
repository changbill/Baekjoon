class Solution {
    int len, min;
    String begin, target;
    String[] words;
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        len = begin.length();
        this.begin = begin;
        this.target = target;
        this.words = words;
        
        boolean flag = false;
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if(word.equals(target)) flag = true;
        }
        if(!flag) return 0;
        
        // words를 하나하나 비교해가며, charAt이 하나만 다른지 확인
        String now = begin;
        visited = new boolean[words.length];
        min = Integer.MAX_VALUE;
        dfs(0, now);
        
        int answer = min;
        return answer;
    }
    
    void dfs(int depth, String now) {
        if(target.equals(now)) {
            min = Math.min(min, depth);
            return;
        }
        
        loop:
        for(int i = 0; i < words.length; i++) {
            if(visited[i]) continue;
            String word = words[i];
            int cnt = 0;
            for(int j = 0; j < len; j++) {
                if(now.charAt(j) != word.charAt(j)) cnt++;
                if(cnt > 1) continue loop;
            }
            visited[i] = true;
            dfs(depth + 1, word);
            visited[i] = false;
        }
    }
}