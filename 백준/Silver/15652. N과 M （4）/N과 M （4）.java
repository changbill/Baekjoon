import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int arr[];
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth, int idx) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N];
        dfs(0, 1);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}