import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int indegree[] = new int[N+1];  // 각 문제마다 먼저 풀면 좋은 문제 개수
        List<List<Integer>> relation = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            relation.add(new ArrayList<>());
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            indegree[B]++;
            relation.get(A).add(B);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                pq.add(i);
            }
        }

        while(!pq.isEmpty()) {
            int zeroConn = pq.poll();
            q.add(zeroConn);
            for(int b : relation.get(zeroConn)) {
                indegree[b]--;
                if(indegree[b] == 0) {
                    pq.add(b);
                }
            }
        }

        while(!q.isEmpty()) {
            sb.append(q.poll() + " ");
        }

        System.out.println(sb);
    }
}