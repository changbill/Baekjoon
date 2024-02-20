
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] weights = new int[N+1];
        int[] cost = new int[N+1];
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K+1];
        // 물건을 한개씩 고려하겠다
        for (int i = 1; i <= N; i++) {
            // w : 임시 배낭의 무게
            for (int w = 0; w <= K; w++) {
                if(weights[i] <= w) { // 물건이 임시 배낭 허용 용량 내일 경우
                    // dp배열에는 최대값이 할당된다
                    // dp배열은 물건 인덱스, 무게 인덱스 두가지가 들어가는데
                    // 이는 단순히 해당 물건까지 따져봤다, 해당 무게까지 따져봤다 의미다
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i]]+cost[i]);
                } else { // 물건이 배낭 허용 용량보다 클 경우
                    // 이전 물건까지 따졌던 값 그대로 할당
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}