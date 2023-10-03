import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int NArr[] = new int[N+1]; // 동전의 가치
        int K = Integer.parseInt(st.nextToken());
        int dp[] = new int[K+1]; // 가치의 합

        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            NArr[i] = Integer.parseInt(br.readLine());
            for (int j = 0; j <= K; j++) {
                if(j >= NArr[i]) {
                    dp[j] += dp[j-NArr[i]];
                }
            }
        }

        System.out.println(dp[K]);
    }
}