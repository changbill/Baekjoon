import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][10];
        for (int j = 0; j < 10; j++) {
            dp[N][j] = 1;
        }

        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum = (sum + memo(1,i))%1_000_000_000;
        }

        System.out.println(sum);
    }

    public static int memo(int fst, int sec) {
        if(fst == N) {
            return dp[fst][sec];
        }

        int nextF = fst+1;
        if(dp[fst][sec] != 0) return dp[fst][sec];
        
        if(sec == 0) {
            return dp[fst][sec] = memo(nextF,sec+1);
        } else if(sec == 9) {
            return dp[fst][sec] = memo(nextF,sec-1);
        } else {
            return dp[fst][sec] = (memo(nextF,sec+1) + memo(nextF,sec-1))%1_000_000_000;
        }
    }
}
