class Solution {
    int[] dr = {0, 0, -1, 1};
    int[] dc = {1, -1, 0, 0};
    int answer = Integer.MAX_VALUE;
    int[] redDest, blueDest, red, blue;
    int[][] maze;
    int n, m;
    boolean[][] rvisited, bvisited;
    public int solution(int[][] maze1) {
        maze = maze1;
        n = maze.length;
        m = maze[0].length;
        
        rvisited = new boolean[n][m];
        bvisited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maze[i][j] == 1) red = new int[]{i, j};
                if(maze[i][j] == 2) blue = new int[]{i, j};
                if(maze[i][j] == 3) redDest = new int[]{i, j};
                if(maze[i][j] == 4) blueDest = new int[]{i, j};
            }
        }
        
        rvisited[red[0]][red[1]] = true;
        bvisited[blue[0]][blue[1]] = true;
        dfs(0);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    void dfs(int cnt) {
        boolean redFinished = red[0] == redDest[0] && red[1] == redDest[1];
        boolean blueFinished = blue[0] == blueDest[0] && blue[1] == blueDest[1];
        if(redFinished && blueFinished) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int rnr = red[0];
            int rnc = red[1];
            if(!redFinished) {
                rnr += dr[i];
                rnc += dc[i];
                if(rnr < 0 || rnc < 0 || rnr >= n || rnc >= m || rvisited[rnr][rnc] || maze[rnr][rnc] == 5) continue;
            }
            
            for(int j = 0; j < 4; j++) {
                int bnr = blue[0];
                int bnc = blue[1];
                if(!blueFinished) {
                    bnr += dr[j];
                    bnc += dc[j];
                    if(bnr < 0 || bnc < 0 || bnr >= n || bnc >= m || bvisited[bnr][bnc] || maze[bnr][bnc] == 5 || (rnr == blue[0] && rnc == blue[1] && bnr == red[0] && bnc == red[1])) continue;
                }
                if(rnr == bnr && rnc == bnc) continue;
                
                int[] tred = {red[0], red[1]};
                int[] tblue = {blue[0], blue[1]};
                red[0] = rnr;
                red[1] = rnc;
                blue[0] = bnr;
                blue[1] = bnc;
                rvisited[rnr][rnc] = true;
                bvisited[bnr][bnc] = true;
                dfs(cnt+1);
                rvisited[rnr][rnc] = false;
                bvisited[bnr][bnc] = false;
                red[0] = tred[0];
                red[1] = tred[1];
                blue[0] = tblue[0];
                blue[1] = tblue[1];
            }
        }
    }
}