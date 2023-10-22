
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int N, K, min, cnt;
    static int dp[] = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());               // 수빈이 위치
        K = Integer.parseInt(st.nextToken());               // 동생 위치
        min = Integer.MAX_VALUE;                            // 최소 시간

        if(N >= K) {        // N이 K보다 크다면 -1해주는 수 밖에 없음
            min = N-K;
            cnt = 1;
        } else{
            bfs();
        }

        sb.append(min+"\n"+cnt);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        dp[N] = 1;

        while(!q.isEmpty()) {
            int tmp = q.poll();             // 걸린 시간

            if(min < dp[tmp]) return;

            for (int i = 0; i < 3; i++) {
                int x = 0;
                switch(i) {
                    case 0:
                        x= tmp + 1;
                        break;
                    case 1:
                        x= tmp - 1;
                        break;
                    case 2:
                        x= tmp * 2;
                        break;
                }

                if(x > 100000 || x < 0) continue;

                if(x == K) {
                    min = dp[tmp];
                    cnt++;
                }

                if(dp[x] == 0 || dp[x] == dp[tmp] + 1) {
                    q.add(x);
                    dp[x] = dp[tmp] + 1;
                }
            }
        }
    }
}
