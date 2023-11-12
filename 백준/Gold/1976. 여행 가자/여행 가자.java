import java.io.*;
import java.util.*;

public class Main {

    static int arr[], N, M;
    static List<Integer> city[];
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());        // 도시의 수
        M = Integer.parseInt(br.readLine());        // 여행 계획에 속한 도시의 수
        city = new List[N+1];         // 연결 정보
        for (int i = 1; i <= N; i++) {
            city[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {     // 연결되어 있다면
                    city[i].add(j);             // i에 연결되어 있는 도시 j 저장
                }
            }
        }

        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }   // 여행 가봐야 하는 곳 배열에 저장


        for (int i = 0; i < M - 1; i++) {
            visit = new boolean[N+1];
            if(!bfs(arr[i], arr[i+1])) {    // arr[i]에서 시작해서 arr[i+1]까지 가는 최소 여행 경로 찾기
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static boolean bfs(int start,int end) {
        Queue<Integer> q = new LinkedList<>();  // 방문할 도시 넣기
        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()) {
            int tmp = q.poll();     // 방문 도시 번호
            if(tmp == end) return true;

            for (int i = 0; i < city[tmp].size(); i++) {
                // 해당 도시와 연결된 곳 찾기
                if(!visit[city[tmp].get(i)]) {
                    visit[city[tmp].get(i)] = true;
                    q.add(city[tmp].get(i));
                }
            }
        }
        return false;
    }
}