import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 학생 수
        int M = Integer.parseInt(st.nextToken());   // 키를 비교한 횟수

        List<Integer> BArr[] = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            BArr[i] = new ArrayList<>();
        }

        int indegree[] = new int[N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            BArr[A].add(B);
            indegree[B]++;
        }

        Queue<Integer> result = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);
            for(int i = 0; i < BArr[node].size(); i++) {
                int tmp = BArr[node].get(i);
                indegree[tmp]--;
                if(indegree[tmp] == 0) {
                    q.add(tmp);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty()) {
            int tmp = result.poll();
            sb.append(tmp + " ");
        }

        System.out.println(sb);
    }
}