import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());    // 동전 개수
            int nCoinArr[] = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int n = 1; n <= N; n++) {
                nCoinArr[n] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());    // 금액

            int costCntDp[][] = new int[N+1][M+1];      // [몇번째 동전 사용중인지, 만든 금액]
            for(int n = 1; n <= N; n++) {
                int nCoinVal = nCoinArr[n];
                for(int i = 1; i <= M; i++) {
                    if(i % nCoinVal == 0) {
                        costCntDp[n][i]++;
                    }
                    for(int j = nCoinVal; j <= i; j += nCoinVal) {
                        costCntDp[n][i] += costCntDp[n-1][i - j];
                    }
                    costCntDp[n][i] += costCntDp[n-1][i];
                }
            }

            System.out.println(costCntDp[N][M]);
        }
    }
}