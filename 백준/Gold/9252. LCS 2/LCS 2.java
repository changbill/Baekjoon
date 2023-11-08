import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] one = br.readLine().toCharArray();
        char[] two = br.readLine().toCharArray();

        int dp[][] = new int[one.length+1][two.length+1];   // 0번째 인덱스 줄들 배열 범위 넘어가지 않도록 비워두기

        for (int i = 1; i < one.length+1; i++) {
            for (int j = 1; j < two.length+1; j++) {
                if(one[i-1] == two[j-1]) {      // 두 String형에서 알파벳이 같다면
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int val = dp[one.length][two.length];
        sb.append(val+"\n");
        int r = one.length;         // dp는 인덱스 1 ~ one.length 까지
        int c = two.length;
        Stack<Character> s = new Stack<>();

        while(r>0 && c > 0) {
            if(dp[r][c] == dp[r-1][c]){
                r--;
            } else if(dp[r][c] == dp[r][c-1]) {
                c--;
            } else {
                s.add(one[r-1]);
                r--; c--;
            }
        }

        // one, two char[]은 인덱스 0 ~ one.length-1까지
        int tmp = s.size();
        for (int i = 0; i < tmp; i++) {
            sb.append(s.pop());
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}