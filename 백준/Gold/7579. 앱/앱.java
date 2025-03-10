import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 앱 개수
        int M = Integer.parseInt(st.nextToken());       // 확보해야하는 메모리 바이트 수
        int ans = Integer.MAX_VALUE;

        int nMemoryArr[] = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int n = 1; n <= N; n++) {
            nMemoryArr[n] = Integer.parseInt(st.nextToken());
        }

        int nCostArr[] = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int n = 1; n <= N; n++) {
            nCostArr[n] = Integer.parseInt(st.nextToken());
        }

        int dp[][] = new int[N+1][10001];
        for(int n = 1; n <= N; n++) {
            int memory = nMemoryArr[n];
            int cost = nCostArr[n];

            for(int i = 0; i <= 10000; i++) {
                if(i >= cost) {
                    dp[n][i] = Math.max(dp[n-1][i-cost] + memory, dp[n-1][i]);
                } else {
                    dp[n][i] = dp[n-1][i];
                }

                if(dp[n][i] >= M) {
                    ans = Math.min(ans, i);
                }
            }
        }

        System.out.println(ans);
    }
}