import java.io.*;
import java.util.*;

public class Main {
    static int V,E, p[];
    static long minWeight, sum;
    static class Node {
        int r,c,weight;
        public Node(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }
    }

    public static int find(int x) {
        if(p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    public static boolean union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);

        if(rootx == rooty) return false;
        p[rooty] = rootx;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            sum += C;
            list.add(new Node(A, B, C));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        // make-set
        p = new int[V+1];
        for (int i = 0; i < V; i++) {
            p[i] = i;
        }

        boolean check[] = new boolean[V+1];
        for (int i = 0; i < E; i++) {
            int dr = list.get(i).r;
            int dc = list.get(i).c;
            if(union(dr,dc)) {
                minWeight += list.get(i).weight;
            }
        }

        long ans = sum - minWeight;

        for (int i = 1; i < V; i++) {
            if(find(i) != find(i+1)) {
                ans = -1;
                break;
            }
        }

        bw.write(Long.toString(ans));
        bw.close();
        br.close();
    }
}