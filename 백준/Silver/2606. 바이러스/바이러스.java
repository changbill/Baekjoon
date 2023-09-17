import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int map[][];		// 각 정점간 탐색 경로 저장
    static boolean visit[];	// 정점 탐색여부 체크
    static int n, m, v;		// 정점, 간선, 시작 정점
    static int count = 0;	// 정점과 연결된 바이러스 걸리는 컴퓨터 수

    public static int bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visit[i] = true;
        
        while(!q.isEmpty()) {
            int temp = q.poll();

            for(int k=1; k<=n; k++) {
                if(map[temp][k] == 1 && visit[k] == false) {
                    q.offer(k);
                    visit[k] = true;
                    count ++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());	// 컴퓨터 수(정점)
        m = Integer.parseInt(br.readLine());	// 연결된 컴퓨터 쌍의 수(간선)
        v = 1;	// 시작정점 1
        map = new int[n+1][n+1];	// 각 정점간 탐색 경로를 저장할 배열(카운팅 정렬)
        visit = new boolean[n+1];	// 정점의 탐색 여부 체크

        // 인접행렬을 이용한 풀이
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a]= 1; // 양방향 그래프이므로 양쪽 값 넣어주기
        }

        bw.write(Integer.toString(bfs(1)));
        br.close();
        bw.close();
    }
}