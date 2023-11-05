import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, arr[], dp[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }       // 입력 완

        dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        sb.append((max)+"\n");

        int tmpMax = max;
        int ansArr[] = new int[max+1];
        for (int i = N-1; i >= 0; i--) {
            if(dp[i] == tmpMax) {
                ansArr[tmpMax] = arr[i];
                tmpMax--;
            }
        }

        for (int i = 1; i <= max; i++) {
            sb.append(ansArr[i] + " ");
        }

        System.out.println(sb.toString());
    }
}