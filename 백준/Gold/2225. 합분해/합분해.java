import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long dp[][] = new long[K+1][N+1]; // N이 되기 위해 K개를 더해야하고, N이 남은 값 dp배열

//        for (int i = 0; i <= N; i++) {
//            dp[1][i] = 1; // N이 되기 위해 1개를 더해야하고, i가 남은 값일 경우는 1가지
//        }

        dp[0][0] = 1;

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                for (int l = 0; l <= j; l++) {
                    dp[i][j] += dp[i-1][l];   // j가 되기 위해 i개의 수를 더한 경우의 수는, i-1개를 합했을 때 나온 경우의 수들을 전부 합한 수이다.
                    // j-l / l 둘을 더해주는 식으로 i-1에 숫자 1개를 더하는 경우의 수는 1이므로 (i-1의 경우의 수 * 1) = i-1의 경우의 수
                    // 마지막 수가 나올 수 있는 모든 경우의 수는 0~j이고 dp[i-1][l] 반복문을 전부 더하면 모든 경우의 수를 구한 것이다
                    dp[i][j]%=1_000_000_000;
                }
            }
        }

        // dp[2][2] += 1,2 / 1,1 / 1,0
        // dp[4][4] += 3,4 / 3,3 / 3,2 / 3,1 / 3,0

        bw.write(String.valueOf(dp[K][N]));
        bw.flush();
        bw.close();
        br.close();
    }
}