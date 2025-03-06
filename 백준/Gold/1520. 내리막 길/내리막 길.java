import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static int mapArr[][], dp[][];
    static int dr[] = {0,0,-1,1};
    static int dc[] = {1,-1,0,0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        mapArr = new int[R+1][C+1];
        dp = new int[R+1][C+1];
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                dp[i][j] = -1;
            }
        }
        // 델타로 이동
        // 이전 위치 파라미터로 전달하고 해당 위치 제외
        // 마지막 위치 1 반환 후 dp로 메모이제이션

        for(int r = 1; r <= R; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= C; c++) {
                mapArr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(1,1));
    }

    static int dfs(int nowR, int nowC) {
        if(nowR == R & nowC == C) {
            return 1;
        }

        if(dp[nowR][nowC] != -1) {
            return dp[nowR][nowC];
        }

        dp[nowR][nowC] = 0;

        int cnt = 0;
        for(int i = 0; i < 4; i++) {
            int afterR = nowR + dr[i];
            int afterC = nowC + dc[i];
            if(
                    afterR <= R && afterC <= C
                    && afterR > 0 && afterC > 0
                    && mapArr[nowR][nowC] > mapArr[afterR][afterC]
            ) {
                cnt += dfs(afterR, afterC);
            }
        }

        return dp[nowR][nowC] = cnt;
    }
}