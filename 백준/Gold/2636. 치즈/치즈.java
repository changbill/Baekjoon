import java.io.*;
import java.util.*;

public class Main {

    static int r, c;
    static int[][] map;
    static boolean[][] visited;
    static int dr[] = {0,0,-1,1};
    static int dc[] = {1,-1,0,0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r+1][c+1];

        for(int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;    // 마지막 치즈조각 수
        int ans = 0;    // 치즈가 녹아서 사라지는데 걸리는 시간
        while(true) {
            visited = new boolean[r+1][c+1];
            int tmp = 0;
            for(int i = 1; i <= r; i++) {
                bfs(i, 1);
                bfs(i, c);
            }

            for(int i = 1; i <= c; i++) {
                bfs(1, i);
                bfs(r, i);
            }

            for(int i = 1; i <= r; i++) {
                for(int j = 1; j <= c; j++) {
                    if(map[i][j] == -1) {
                        tmp++;
                        map[i][j] = 0;
                    }
                }
            }
            if(tmp > 0) {
                ans++;
                cnt = tmp;
            } else {
                break;
            }
        }

        System.out.println(ans);
        System.out.println(cnt);
    }

    private static void bfs(int tr, int tc) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{tr, tc});
        visited[tr][tc] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(map[cur[0]][cur[1]] == 1) {
                map[cur[0]][cur[1]] = -1;
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr > 0 && nc > 0 && nr < r && nc < c && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }


}