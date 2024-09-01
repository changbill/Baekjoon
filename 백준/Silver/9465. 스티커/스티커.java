import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t< T; t++) {
            int N = Integer.parseInt(br.readLine());
            int NArr[][] = new int[3][N+1];
            for(int i = 1; i <= 2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int n = 1; n <= N; n++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    NArr[i][n] = tmp;
                }
            } // 입력 완료

            // 0: 둘다 선택 X
            // 1: 1 선택
            // 2: 2 선택
            int dp[][] = new int[3][N+1];
            int max = Integer.MIN_VALUE;
            for(int i = 1; i <= N; i++) {
                dp[0][i] = Math.max(Math.max(dp[0][i-1], dp[1][i-1]), dp[2][i-1]);
                dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + NArr[1][i];
                dp[2][i] = Math.max(dp[0][i-1], dp[1][i-1]) + NArr[2][i];

                max = Math.max(max,Math.max(Math.max(dp[0][i], dp[1][i]),dp[2][i]));
            }

            sb.append(max + "\n");
        }

        System.out.println(sb);
    }
}