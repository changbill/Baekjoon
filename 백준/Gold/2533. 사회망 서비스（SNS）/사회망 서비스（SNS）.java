import java.io.*;
import java.util.*;

public class Main {

    static int N, dp[][];
    static boolean flag[];
    static List<Integer>[] edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // 트리의 정점의 개수 2 ≤ N ≤ 1,000,000
        edge = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            edge[U].add(V);
            edge[V].add(U);
        }

        flag = new boolean[N+1];
        dp = new int[N+1][2];   // [n][0] : 얼리어답터 아닌 경우, [n][1] : 얼리어답터인 경우
        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int node) {
        dp[node][0] = 0;
        dp[node][1] = 1;

        flag[node] = true;

        for(int child : edge[node]) {
            if(!flag[child]) {
                dfs(child);
                dp[node][0] += dp[child][1];
                dp[node][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }

        flag[node] = true;
    }
}