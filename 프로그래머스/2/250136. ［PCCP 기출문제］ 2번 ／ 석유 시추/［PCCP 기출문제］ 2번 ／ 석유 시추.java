import java.util.*;

class Solution {
    int[][] land, numberedLand;
    boolean[][] visited;
    int n, m, number;
    int[] dr = {0, 0, -1, 1};
    int[] dc = {1, -1, 0, 0};
    public int solution(int[][] tland) {
        land = tland;
        n = land.length;
        m = land[0].length;
        numberedLand = new int[n][m];
        visited = new boolean[n][m];
        HashMap<Integer, Integer> amount = new HashMap<>();
        number = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    Deque<int[]> dq = new ArrayDeque<>();
                    dq.offerLast(new int[]{i,j});
                    visited[i][j] = true;
                    numberedLand[i][j] = number;
                    int cnt = 1;
                    while(!dq.isEmpty()) {
                        int[] coord = dq.pollFirst();
                        for(int k = 0; k < 4; k++) {
                            int nr = dr[k] + coord[0];
                            int nc = dc[k] + coord[1];
                            if(nr >= 0 && nc >= 0 && nr < n && nc < m && land[nr][nc] == 1 && !visited[nr][nc]) {
                                dq.offerLast(new int[]{nr,nc});
                                numberedLand[nr][nc] = number;
                                visited[nr][nc] = true;
                                cnt++;
                            }
                        }
                    }
                    amount.put(number, cnt);
                    number++;
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if(numberedLand[j][i] != 0 && !list.contains(numberedLand[j][i])) {
                    list.add(numberedLand[j][i]);
                }
            }
            
            int sum = 0;
            for(int number : list) {
                sum += amount.get(number);
            }
            answer = Math.max(sum, answer);
        }
        
        return answer;
    }
    
    void dfs(int r, int c) {
        
        for(int i = 0; i < 4; i++) {
            int nr = dr[i] + r;
            int nc = dc[i] + c;
            if(nr >= 0 && nc >= 0 && nr < n && nc < m && land[nr][nc] == 1 && !visited[nr][nc]) {
                numberedLand[nr][nc] = number;
                visited[nr][nc] = true;
            }
        }
    }
}