import java.io.*;
import java.util.*;

public class Main {

    static int N,Arr[][],cnt, ans;
    static boolean[][] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Arr = new int[N+1][N+1];
        visit = new boolean[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                Arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        cnt=0;
        dfs(1,2,1);

        ans = 0;
        if(cnt > 0) {
            ans = cnt;
        }

        bw.write(Integer.toString(ans));
        bw.close();
        br.close();
    }

    public static void dfs(int r, int c, int dir) {
        if(r >= N && c >= N) {
            cnt++;
            return;
        }

        switch(dir) {
            case 1: // 우로
                if(c+1<=N && Arr[r][c+1] == 0) {
                    dfs(r,c+1,1);
                }
                break;
            case 2: // 아래로
                if(r+1<=N && Arr[r+1][c] == 0) {
                    dfs(r+1,c,2);
                }
                break;
            case 3: // 대각선으로
                if(c+1<=N && Arr[r][c+1] == 0) {
                    dfs(r,c+1,1);
                }
                if(r+1<=N && Arr[r+1][c] == 0) {
                    dfs(r+1,c,2);
                }
                break;
        }

        // 대각선 방향은 공통이므로 여기에 한꺼번에
        if(r+1<=N && c+1<=N && Arr[r][c+1] == 0 && Arr[r+1][c] == 0 && Arr[r+1][c+1] == 0) {
            dfs(r+1,c+1,3);
        }
    }
}