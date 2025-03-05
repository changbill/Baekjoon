import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long dp[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new long[10010];
        for (int i = 0; i < 10; i++) {
            dp[N * 10 + i] = 1;
        }

        for (int i = N; i > 0; i--) {
            for (int j = 0; j < 10; j++) {
                long sum = 0;
                for (int k = j; k < 10; k++) {
                    sum += dp[i * 10 + k];
                }
                dp[(i - 1) * 10 + j] = sum % 10_007;
            }
        }

        System.out.println(dp[0]);
    }
}