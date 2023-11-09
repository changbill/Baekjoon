import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, K, X, Y, tr, tc, cnt;
    static int dr[] = {1, -1, 0 ,0};
    static int dc[] = {0,0,1,-1};
    static boolean arr[][], visit[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());       // 가로길이
            N = Integer.parseInt(st.nextToken());       // 세로길이
            K = Integer.parseInt(st.nextToken());       // 배추가 심어져 있는 위치 개수
            arr = new boolean[N][M];
            visit = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());   // 가로
                Y = Integer.parseInt(st.nextToken());   // 세로

                arr[Y][X] = true;
            }

            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j] && !visit[i][j]) {
                        Node node = new Node(i, j);
                        bfs(node);
                        cnt++;
                    }
                }
            }
            sb.append(cnt+"\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            Node tmp = q.poll();
            arr[tmp.r][tmp.c] = false;
            for (int i = 0; i < 4; i++) {
                tr = tmp.r + dr[i];
                tc = tmp.c + dc[i];
                if(tr>=0 && tc >= 0 && tr<N && tc<M && !visit[tr][tc] &&arr[tr][tc]) {
                    visit[tr][tc] = true;
                    q.add(new Node(tr,tc));
                }
            }
        }


    }
}