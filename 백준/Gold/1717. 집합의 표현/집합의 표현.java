import java.io.*;
import java.util.*;

public class Main {

    static int N, M, parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int p = 0; p <= N; p++) {
            parent[p] = p;
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            boolean isUnion = Integer.parseInt(st.nextToken()) == 0;

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(isUnion) {
                union(a, b);
            } else {
                if(isSameSet(a, b)) {
                    sb.append("YES" + "\n");
                } else {
                    sb.append("NO" + "\n");
                }
            }
        }

        System.out.println(sb);
    }

    static void union(int a, int b) {
        // 합치는 로직
        parent[findParent(b)] = findParent(a);
    }

    static int findParent(int x) {
        if(x == parent[x]) {
            return x;
        }
        return findParent(parent[x]);
    }

    static boolean isSameSet(int a, int b) {
        int pA = findParent(a);
        int pB = findParent(b);

        if(pA == pB) {
            return true;
        }
        return false;
    }
}