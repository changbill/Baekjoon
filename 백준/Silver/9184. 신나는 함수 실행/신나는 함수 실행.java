import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long[][][] dp = new long[21][21][21];

        for(int i = 0; i < 21; i++) {
            for(int j = 0 ; j < 21; j++) {
                for(int k = 0; k < 21; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        for(int i = 0; i < 21; i++) {
            for(int j = 0; j < 21; j++) {
                dp[0][i][j] = 1;
                dp[i][0][j] = 1;
                dp[i][j][0] = 1;
            }
        }

        for(int i = 1; i < 21; i++) {
            for(int j = i+1; j < 21; j++) {
                for(int k = j+1; k < 21; k++) {
                    dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
                }
            }
        }

        for(int i = 1; i < 21; i++) {
            for(int j = 1; j < 21; j++) {
                for(int k = 1; k < 21; k++) {
                    if(dp[i][j][k] == -1) {
                        dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) {
                break;
            }

            int newA = a;
            int newB = b;
            int newC = c;

            if(a <= 0 || b <= 0 || c <= 0) {
                newA = newB = newC = 0;
            } else if(a > 20 || b > 20 || c > 20) {
                newA = newB = newC = 20;
            }

            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, dp[newA][newB][newC]));
        }

        System.out.println(sb);
    }
}