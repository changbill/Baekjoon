import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 수행해야할 작업 수
        int indegree[] = new int[N+1];              // 위상정렬 위한 연결되어있는 부모 노드 개수
        int timeArr[] = new int[N+1];               // 작업마다 걸린 시간
        List<List<Integer>> relation = new ArrayList<>();   // 작업간 선행 관계
        for(int i = 0; i <= N; i++) {
            relation.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            timeArr[i] = time;
            int taskCnt = Integer.parseInt(st.nextToken());
            for(int j = 0; j < taskCnt; j++) {
                int taskNum = Integer.parseInt(st.nextToken());
                relation.get(taskNum).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N+1];
        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                q.add(i);
                result[i] = timeArr[i];
            }
        }

        while(!q.isEmpty()) {
            int zeroConn = q.poll();
            for(int conn : relation.get(zeroConn)) {
                indegree[conn]--;
                result[conn] = Math.max(result[conn],result[zeroConn] + timeArr[conn]);
                if(indegree[conn] == 0) {
                    q.add(conn);
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max,result[i]);
        }

        System.out.println(max);
    }
}