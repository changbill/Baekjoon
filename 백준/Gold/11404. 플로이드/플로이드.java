import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int NArr[][] = new int[N+1][N+1];
        for(int i = 1; i<=N; i++) {
            for(int j = 1; j <= N; j++) {
                NArr[i][j] = i != j ? INF : 0;
            }
        }
        int M = Integer.parseInt(br.readLine());

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            NArr[start][end] = Math.min(NArr[start][end], cost);
        }

        for(int i = 1; i<=N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= N; k++) {
                    if(NArr[j][k] > NArr[j][i] + NArr[i][k]) {
                        NArr[j][k] = NArr[j][i] + NArr[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j<= N; j++) {
                int ans = NArr[i][j] == INF ? 0 : NArr[i][j];
                sb.append(ans+ " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}