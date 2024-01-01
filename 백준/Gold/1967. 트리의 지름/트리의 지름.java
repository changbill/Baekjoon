import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int num, weight;
        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
    static ArrayList<Node> edge[];
    static boolean visited[];
    static int max;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 노드 개수
        max = Integer.MIN_VALUE;
        edge = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edge[parent].add(new Node(child, weight));
            edge[child].add(new Node(parent, weight));
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i, 0);
        }

        bw.write(Integer.toString(max));
        bw.close();
        br.close();
    }

    public static void dfs(int node, int weight) {
        for(Node tmp : edge[node]) {
            int num = tmp.num;
            int wei = tmp.weight;

            if(!visited[num]) {
                visited[num] = true;
                dfs(num, weight+wei);
            }
        }

        max = Math.max(max, weight);
    }
}