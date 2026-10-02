import java.util.*;

class Solution {
    int[][] dungeons;
    int k, max;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        
        visited = new boolean[dungeons.length];
        max = 0;
        dfs(k, 0);
        
        int answer = max;
        return answer;
    }
    
    void dfs(int point, int cnt) {
        max = Math.max(max, cnt);
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i]) continue;
            if(point >= dungeons[i][0]) {
                visited[i] = true;
                dfs(point - dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
}