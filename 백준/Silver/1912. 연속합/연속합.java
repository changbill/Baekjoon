import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            dp[i] = num;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i-1] + dp[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}