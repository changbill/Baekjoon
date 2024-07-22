import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 삼각형의 크기
        int nArr[][] = new int[n+1][n+1];

        for(int t = 1; t <= n; t++) {
            st = new StringTokenizer(br.readLine());
            int cIdx = 1;
            while(cIdx <= t) {
                int val = Integer.parseInt(st.nextToken());
                nArr[t][cIdx] = Math.max(nArr[t-1][cIdx-1], nArr[t-1][cIdx]) + val;
                cIdx++;
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, nArr[n][i]);
        }

        System.out.println(max);
    }
}