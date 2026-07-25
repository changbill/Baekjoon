class Solution {
    int[] dr = {0,0,-1,1};
    int[] dc = {1,-1,0,0};
    char[][] map;
    boolean[][] visited;
    boolean isCorrect;
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i < 5; i++) {
            map = new char[5][5];    // 2: 응시자 자리, 3: 빈 테이블, 4: 파티션
            visited = new boolean[5][5];
            isCorrect = true;
            for(int j = 0; j < 5; j++) {
                String str = places[i][j];
                for(int k = 0; k < 5; k++) {
                    map[j][k] = str.charAt(k);
                }
            }
            
            loop:
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(!isCorrect) break loop;
                    if(map[j][k] == 'P') {
                        visited[j][k] = true;
                        dfs(j, k, 0);
                        visited[j][k] = false;
                    }
                }
            }
            answer[i] = isCorrect ? 1 : 0;
        }
        
        return answer;
    }
    
    void dfs(int r, int c, int cnt) {
        if(cnt == 2 || !isCorrect) {
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || visited[nr][nc] || map[nr][nc] == 'X') continue;
            if(map[nr][nc] == 'P') {
                isCorrect = false;
                return;
            }
            visited[nr][nc] = true;
            dfs(nr, nc, cnt+1);
            if(!isCorrect) return;
            visited[nr][nc] = false;
        }
    }
}