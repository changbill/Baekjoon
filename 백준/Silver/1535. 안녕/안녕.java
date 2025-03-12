import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int costArr[] = new int[N+1];
        int rewardArr[] = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int n = 1; n <= N; n++) {
            costArr[n] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int n = 1; n <= N; n++) {
            rewardArr[n] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][101];   // row: 사람, col: 체력
        for(int n = 1; n <= N; n++) {
            int cost = costArr[n];
            int reward = rewardArr[n];

            for(int i = 1; i <= 100; i++) {
                if(i >= cost) {
                    dp[n][i] = Math.max(dp[n-1][i-cost] + reward, dp[n-1][i]);
                } else {
                    dp[n][i] = dp[n-1][i];
                }
            }
        }

        System.out.println(dp[N][99]);
    }
}