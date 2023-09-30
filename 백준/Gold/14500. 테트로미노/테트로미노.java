import java.io.*;
import java.util.*;

public class Main {

    static int N,M,Arr[][],ans,tmp;
    static boolean[][] visit;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Arr = new int[N][M];
        visit = new boolean[N][M];



        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                Arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i,j,1,Arr[i][j]);
                visit[i][j] = false;
                check(i,j);
            }
        }

        bw.write(Integer.toString(ans));
        bw.close();
        br.close();
    }

    public static void dfs(int r, int c, int cnt, int sum) {
        if(cnt >= 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int tr = r + dr[i];
            int tc = c + dc[i];

            if(tr >= 0 && tr < N && tc >= 0 && tc < M && !visit[tr][tc]) {
                visit[tr][tc] = true;
                dfs(tr, tc, cnt+1, sum+Arr[tr][tc]);
                visit[tr][tc] = false;
            }
        }
    }

    public static void check(int r, int c) {
        tmp = Arr[r][c];
        if(r+2<N && c-1>=0) {
            ans = Math.max(ans, tmp + Arr[r+1][c-1] + Arr[r+1][c] + Arr[r+2][c]);
        }
        if(r+1<N && c-1>=0 && c+1<M) {
            ans = Math.max(ans, tmp + Arr[r+1][c-1] + Arr[r+1][c] + Arr[r+1][c+1]);
        }
        if(r+2<N && c+1 <M) {
            ans = Math.max(ans, tmp + Arr[r+1][c] + Arr[r+1][c+1] + Arr[r+2][c]);
        }
        if(r+1<N && c+2 < M) {
            ans = Math.max(ans, tmp + Arr[r][c+1] + Arr[r][c+2] + Arr[r+1][c+1]);
        }
    }
}