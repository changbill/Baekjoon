import java.io.*;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] RDP = new int[N+1];
        int[] GDP = new int[N+1];
        int[] BDP = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(i == 1) {
                RDP[i] = R;
                GDP[i] = G;
                BDP[i] = B;
            } else {
                RDP[i] = R + Math.min(GDP[i-1], BDP[i-1]);
                GDP[i] = G + Math.min(RDP[i-1], BDP[i-1]);
                BDP[i] = B + Math.min(RDP[i-1], GDP[i-1]);
            }
        }

        System.out.println(Math.min(Math.min(RDP[N], GDP[N]), BDP[N]));
    }
}