import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int start, cnt;
        Node(int start, int cnt) {
            this.start = start;
            this.cnt = cnt;
        }
    }
    static int K;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N > K) {
            System.out.println(N-K);
        } else if(N == K) {
            System.out.println(0);
        } else {
            bfs(N, 0);
        }
    }

    // 방문처리를 하는 시점에서 그 위치에 도달하는 최단 시간임
    // 따라서 다시 방문해서 더 빠른 경로를 찾을 수 없음
    // 방문 처리하고 나머지 경로 배제해도 문제 없음
    public static void bfs(int start, int cnt) {
        Queue<Node> q1;
        Queue<Integer> q2;
        visited = new boolean[K*2]; // 이 이상을 넘어갈 일은 없기 때문에 이렇게 범위 지정
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();

        Node n;
        int k;
        q1.add(new Node(start, cnt));

        while(!q1.isEmpty()) {
            n = q1.poll();
            if(n.start == K) {
                System.out.println(n.cnt);
                return;
            }
            visited[n.start] = true;
            q2.add(n.start);
            int num = n.cnt;

            // 순간이동한 경우(2*X)를 전부 구하기
            while(!q2.isEmpty()) {
                k = q2.poll();
                if(k == K) {
                    System.out.println(num);
                    return;
                }
                if(k*2 < K*2 && !visited[k*2]) {  // 순간이동한 곳이 동생 위치의 2배보다 더 작을 때만 queue에 추가
                    q2.add(k * 2);
                    q1.add(new Node(k * 2, num));
                }
            }
            if(n.start+1 < 100_000 && !visited[n.start+1]) {
                q1.add(new Node(n.start + 1, num + 1));
            }
            if(n.start-1 > 0 && !visited[n.start-1]) {
                q1.add(new Node(n.start - 1, num + 1));
            }
        }
    }
}