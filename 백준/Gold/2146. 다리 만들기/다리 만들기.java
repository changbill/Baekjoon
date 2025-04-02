import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int N, landIdx;
    static int[][] dp;
    static PriorityQueue<int[]> pq;

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 각 육지 타일을 dp로 나타내고 나머지 -1
        // 각각 bfs를 돌려 육지에 도달했을 때 가장 가까운 값을 dp에 저장 (단, 바로 옆에 붙어있는 육지의 경우 -1 입력)
        // -> 아마 우선순위 큐로 다익스트라를 돌려야할 것 같다.
        // 마지막 N*N 그래프 dp 반복문 돌려서 최소값 찾기

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        dp = new int[N+1][N+1];

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                int isEarth = Integer.parseInt(st.nextToken());
                if(isEarth == 1) {
                    map[n][i] = 1;
                } else {
                    dp[n][i] = -1;
                }
            }
        }   // 입력 완

        landIdx = 1;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(map[i][j] == 1) {
                    bfs(i,j);
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(dp[i][j] != -1) {
                    dijkstra(i, j, map[i][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(dp[i][j] != -1) {
                    min = Math.min(min, dp[i][j]);
                }
            }
        }

        System.out.println(min);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        visited = new boolean[N+1][N+1];
        landIdx++;

        while(!q.isEmpty()) {
            int[] el = q.poll();
            map[el[0]][el[1]] = landIdx;

            for(int k = 0; k < 4; k++) {
                int row = el[0] + dr[k];
                int col = el[1] + dc[k];

                if(row > 0 && col > 0 && row <= N && col <= N && map[row][col] == 1 && !visited[row][col]) {
                    visited[row][col] = true;
                    q.add(new int[] {row, col});
                }
            }
        }
    }

    private static void dijkstra(int i, int j, int idx) {
        pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);    // 오름차순, 낮은 것부터
        visited = new boolean[N+1][N+1];
        visited[i][j] = true;
        int ans = -1;       // 다리를 놓을 수 없다면 dp에 -1

        for(int d = 0; d < 4; d++) {
            int newRow = i + dr[d];
            int newCol = j + dc[d];

            if(newRow > 0 && newCol > 0 && newRow <= N && newCol <= N && !visited[newRow][newCol]) {
                visited[newRow][newCol] = true;
                if(map[newRow][newCol] == 0) {          // 첫번째 다리 후보지가 바다인지 확인
                    pq.add(new int[]{newRow,newCol,1});
                }
            }
        }

        loop:
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            int row = p[0];
            int col = p[1];
            int dist = p[2];

            for(int d = 0; d < 4; d++) {
                int newRow = row + dr[d];
                int newCol = col + dc[d];

                if(newRow > 0 && newCol > 0 && newRow <= N && newCol <= N && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    if(map[newRow][newCol] != 0 && map[newRow][newCol] != idx) {    // 바다나 같은 대륙이 아니라면
                        ans = dist;     // 다리 완성!
                        break loop;
                    } else if(map[newRow][newCol] == 0) {
                        pq.add(new int[]{newRow,newCol,dist + 1});
                    }
                }
            }
        }

        dp[i][j] = ans;
    }
}