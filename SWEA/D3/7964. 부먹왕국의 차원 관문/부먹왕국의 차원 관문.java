import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            sb.append("#"+(t+1)+" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] NArr = new int[N];
            int D = Integer.parseInt(st.nextToken());
            int ans = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                NArr[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if(NArr[i] == 0) {
                    cnt++;
                } else {
                    ans += cnt/D;
                    cnt = 0;
                }

                if(i==N-1) {
                    ans += cnt/D;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}