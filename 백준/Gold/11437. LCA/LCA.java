import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        Node parent;
        int val;
        Node(int val) {
            this.val = val;
        }
    }

    static List<Integer>[] edge;
    static int d[], p[];
    static boolean flag[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        edge = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            edge[U].add(V);
            edge[V].add(U);
        }

        d = new int[N+1];     // depth arr
        p = new int[N+1];     // parent arr
        flag = new boolean[N+1];

        dfs(1, 0);

        int M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int descA = Integer.parseInt(st.nextToken());
            int descB = Integer.parseInt(st.nextToken());

            lca(descA, descB);
        }

        System.out.println(sb);
    }

    static void dfs(int parent, int depth) {
        flag[parent] = true;
        d[parent] = depth;

        for(int child : edge[parent]) {
            if(!flag[child]) {
                p[child] = parent;
                dfs(child, depth+1);
            }
        }
    }

    static void lca(int descA, int descB) {
        while(d[descA] != d[descB]) {
            if(d[descA] > d[descB]) {
                descA = p[descA];
            } else if(d[descA] < d[descB]) {
                descB = p[descB];
            }
        }

        while(descA != descB) {
            descA = p[descA];
            descB = p[descB];
        }
        sb.append(descA + "\n");
    }
}