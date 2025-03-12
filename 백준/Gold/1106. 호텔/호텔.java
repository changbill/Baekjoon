import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());   // 늘려야하는 호텔의 고객
        int N = Integer.parseInt(st.nextToken());   // 홍보할 수 있는 도시의 개수
        int costArr[] = new int[N+1];               // 홍보 비용
        int rewardArr[] = new int[N+1];             // 증가하는 호텔 고객

        for(int n = 1; n <= N; n++) {
            st  = new StringTokenizer(br.readLine());
            costArr[n] = Integer.parseInt(st.nextToken());
            rewardArr[n] = Integer.parseInt(st.nextToken());
        }

        int dp[][] = new int[N+1][100001];
        int ans = Integer.MAX_VALUE;
        for(int n = 1; n <= N; n++) {
            int cost = costArr[n];
            int reward = rewardArr[n];

            for(int i = 1; i <= 100000; i++) {
                if(i >= cost) {
                    dp[n][i] = Math.max(dp[n-1][i-cost] + reward, dp[n-1][i]);
                    dp[n][i] = Math.max(dp[n][i-cost] + reward, dp[n][i]);
                } else {
                    dp[n][i] = dp[n-1][i];
                }

                if(dp[n][i] >= C) {
                    ans = Math.min(ans, i);
                }
            }
        }

        System.out.println(ans);
    }
}