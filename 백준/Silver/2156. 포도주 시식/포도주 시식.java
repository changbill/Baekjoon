import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dp[][] = new int[N + 1][3];
        for(int n = 1; n <= N; n++) {
            int amount = Integer.parseInt(br.readLine());
            if (n == 1) {
                dp[n][1] = amount;
            } else if(n == 2) {
                dp[n][0] = dp[n-1][1];
                dp[n][1] = dp[n-1][0] + amount;
                dp[n][2] = dp[n-1][1] + amount;
            } else {
                dp[n][0] = Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
                dp[n][1] = dp[n - 1][0] + amount;
                dp[n][2] = dp[n - 1][1] + amount;
            }
        }

        int max = Math.max(Math.max(dp[N][0], dp[N][1]), dp[N][2]);
        System.out.println(max);
    }
}