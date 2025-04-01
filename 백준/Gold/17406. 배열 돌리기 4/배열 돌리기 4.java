import java.io.*;
import java.util.*;

public class Main {

    static int map[][], rotateArr[][];
    static int N, M, K;
    static int min = Integer.MAX_VALUE;
    static boolean visited[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        rotateArr = new int[K+1][4];
        visited = new boolean[K+1];

        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m = 1; m <= M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1; k <= K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            rotateArr[k][1] = r;
            rotateArr[k][2] = c;
            rotateArr[k][3] = s;
        }

        dfs(0);

        System.out.println(min);
    }

    private static void dfs(int cnt) {
        if(cnt == K) {      // K회 회전한 결과
            for(int n = 1; n <= N; n++) {
                int sum = 0;
                for(int m = 1; m <= M; m++) {
                    sum += map[n][m];
                }

                min = Math.min(min, sum);
            }
            return;
        }

        for(int k = 1; k <= K; k++) {
            if(!visited[k]) {
                visited[k] = true;
                int r = rotateArr[k][1];
                int c = rotateArr[k][2];
                int s = rotateArr[k][3];

                for(int i = s; i > 0; i--) {
                    rotate(r, c, i);
                }
                dfs(cnt + 1);
                for(int i = s; i > 0; i--) {
                    opposite(r, c, i);
                }
                visited[k] = false;
            }
        }
    }

    private static void opposite(int r, int c, int s) {
        int tmp = map[r - s][c - s];
        // 위쪽 가로줄
        for(int i = 0; i < 2*s; i++) {
            map[r - s][c - s + i] = map[r - s][c - s + i + 1];
        }

        // 오른쪽 세로줄
        for(int i = 0; i < 2*s; i++) {
            map[r - s + i][c + s] = map[r - s + i + 1][c + s];
        }

        // 아래쪽 가로줄
        for(int i = 0; i < 2*s; i++) {
            map[r + s][c + s - i] = map[r + s][c + s - i - 1];
        }

        // 왼쪽 세로줄
        for(int i = 0; i < 2*s - 1; i++) {
            map[r + s - i][c - s] = map[r + s - i - 1][c - s];
        }

        map[r - s + 1][c - s] = tmp;
    }

    private static void rotate(int r, int c, int s) {
        int tmp = map[r - s][c - s];
        // 왼쪽 세로줄
        for(int i = 0; i < 2*s; i++) {
            map[r - s + i][c - s] = map[r - s + i + 1][c - s];
        }

        // 아래쪽 가로줄
        for(int i = 0; i < 2*s; i++) {
            map[r + s][c - s + i] = map[r + s][c - s + i + 1];
        }

        // 오른쪽 세로줄
        for(int i = 0; i < 2*s; i++) {
            map[r + s - i][c + s] = map[r + s - i - 1][c + s];
        }

        // 위쪽 가로줄
        for(int i = 0; i < 2*s - 1; i++) {
            map[r - s][c + s - i] = map[r - s][c + s -i - 1];
        }

        map[r - s][c - s + 1] = tmp;
    }
}