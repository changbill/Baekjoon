import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V, cnt;
    static boolean[][] NArr;
    static boolean[] visited;
    public static void dfs(int x) {
        visited[x] = true;
        System.out.print(x+" ");

        for (int i = 1; i <= N; i++) {
            if(NArr[x][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;

        while(!q.isEmpty()){
            int tmp = q.poll();
            System.out.print(tmp+" ");

            for (int i = 1; i <= N; i++) {
                if(NArr[tmp][i] && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        NArr = new boolean[N+1][N+1];
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int tmpR = Integer.parseInt(st.nextToken());
            int tmpC = Integer.parseInt(st.nextToken());
            NArr[tmpR][tmpC] = true;
            NArr[tmpC][tmpR] = true;
        }

        cnt = 0;
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);

        br.close();
    }
}