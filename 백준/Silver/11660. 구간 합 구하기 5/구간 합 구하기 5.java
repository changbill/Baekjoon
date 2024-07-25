import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int NArr[][] = new int[N+1][N+1];
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                NArr[i][j] = NArr[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int j = x1; j <= x2; j++) {
                sum += NArr[j][y2] - NArr[j][y1-1];
            }
            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }
}