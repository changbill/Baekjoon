import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int NArr[] = new int[N+1];
        int dp[] = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            NArr[i] = Integer.parseInt(st.nextToken());
            dp[i] = NArr[i];
        }

        int idx = 1;
        while(idx <= N) {
            for(int i = 1; i <= idx; i++) {
                dp[idx] = Math.max(dp[idx], dp[idx-i] + NArr[i]);
            }
            idx++;
        }

        System.out.println(dp[N]);
    }
}