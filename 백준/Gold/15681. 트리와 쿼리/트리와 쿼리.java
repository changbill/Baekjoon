import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        List<Node> children = new ArrayList<>();
        int val;
        Node(int val) {
            this.val = val;
        }
    }

    static List<Integer>[] node;
    static int memo[];
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 트리의 정점
        int R = Integer.parseInt(st.nextToken());   // 루트의 번호
        int Q = Integer.parseInt(st.nextToken());   // 쿼리의 수

        List<List<Integer>> edge = new ArrayList<>(); // 간선 정보
        for(int i = 0; i <= N; i++) {
            edge.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++) {
            // 정점 U, V 간의 간선 정보 입력
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());   // 정점 U
            int V = Integer.parseInt(st.nextToken());   // 정점 V

            edge.get(U).add(V);
            edge.get(V).add(U);
        }

        boolean flag[] = new boolean[N+1];
        node = new List[N+1];   // 부모, 자식 관계가 정리된 트리 구조
        for(int i = 0; i <= N; i++) {
            node[i] = new ArrayList<>();
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(R);

        while(!q.isEmpty()) {
            int parent = q.poll();
            flag[parent] = true;

            for(int child : edge.get(parent)) {
                if(!flag[child]) {
                    q.add(child);
                    node[parent].add(child);
                }
            }
        }

        memo = new int[N+1];
        for(int i = 0; i < Q; i++) {
            int root = Integer.parseInt(br.readLine());     // 서브트리의 루트의 번호
            sb.append(dfs(root) + "\n");
        }

        System.out.println(sb);
    }

    static int dfs(int parent) {
        if(memo[parent] != 0) {
            return memo[parent];
        }

        if(node[parent].size() == 0) {
            return 1;
        }

        sum = 0;
        for(int tmp : node[parent]) {
            sum += dfs(tmp);
        }
        return memo[parent] = sum + 1;
    }
}