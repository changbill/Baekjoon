import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int NArr[], arr[];
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
    public static void dfs(int depth, int idx) {
        if(depth == M) {
            for(int val: arr) {
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            arr[depth] = NArr[i];
            dfs(depth+1, i);
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
        NArr = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            NArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(NArr);
        dfs(0,0);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}