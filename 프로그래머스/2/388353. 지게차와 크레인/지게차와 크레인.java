class Solution {
    char[][] map;
    String[] requests;
    boolean[][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int n, m;
    public int solution(String[] storage, String[] requests) {
        this.requests = requests;
        n = storage.length;
        m = storage[0].length();
        map = new char[n+2][m+2];
        for(int i = 1; i <= n; i++) {
            char[] c = storage[i-1].toCharArray();
            for(int j = 1; j <= c.length; j++) {
                map[i][j] = c[j-1];
            }
        } // 입력 완료
        
        int r = requests.length;
        for(int i = 0; i < r; i++) {
            int rlen = requests[i].length();
            char tc = requests[i].charAt(0);
            visited = new boolean[n+2][m+2];
            if(rlen == 1) {
                visited[0][0] = true;
                edge(0,0,tc);
            } else {
                for(int x = 1; x <= n; x++) {
                    for(int y = 1; y <= m; y++) {
                        if(map[x][y] == tc) map[x][y] = 0;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int x = 1; x <= n; x++) {
            for(int y = 1; y <= m; y++) {
                if(map[x][y] != 0) answer++;
            }
        }
        
        return answer;
    }
    
    void edge(int nr, int nc, char ch) {
        for(int i = 0; i < 4; i++) {
            int tr = nr + dr[i];
            int tc = nc + dc[i];
            if(tr >= 0 && tc >= 0 && tr <= n+1 && tc <= m+1 && !visited[tr][tc]) {
                visited[tr][tc] = true;
                if(map[tr][tc] == ch) {
                    map[tr][tc] = 0;
                    continue;
                } else if(map[tr][tc] != 0) {
                    continue;
                }
                edge(tr,tc,ch);
            }
        }
    }
}