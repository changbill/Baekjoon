import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            boolean NArr[][] = new boolean[N + 1][N + 1];   // 간선 정보
            boolean flag[] = new boolean[N+1];              // 방문 처리
            int M = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                NArr[a][b] = true;
                NArr[b][a] = true;
            }

            int result = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            flag[1] = true;

            while(!q.isEmpty()) {
                int city = q.poll();
                for(int i = 1; i <= N; i++) {
                    if(NArr[city][i] && !flag[i]) {
                        result++;
                        q.add(i);
                        flag[i] = true;
                    }
                }
            }

            sb.append(result+"\n");
        }
        System.out.println(sb);
    }
}