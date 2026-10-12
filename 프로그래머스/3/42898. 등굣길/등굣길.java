class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int INF = 1_000_000_007;
        int[][] map = new int[n+1][m+1];
        boolean[][] prohibit = new boolean[n+1][m+1];
        for(int i = 0; i < puddles.length; i++) {
            int tr = puddles[i][1];
            int tc = puddles[i][0];
            prohibit[tr][tc] = true;
        }
        
        for(int i = 1; i <= m; i++) {
            if(prohibit[1][i]) break;
            map[1][i] = 1;
        }
        
        for(int i = 1; i <= n; i++) {
            if(prohibit[i][1]) break;
            map[i][1] = 1;
        }
        
        for(int i = 2; i <= n; i++) {
            for(int j = 2; j <= m; j++) {
                if(prohibit[i][j]) continue;
                map[i][j] = (map[i-1][j] + map[i][j-1]) % INF;
            }
        }
        
        int answer = map[n][m];
        return answer;
    }
}