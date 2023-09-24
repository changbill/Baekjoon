import java.io.*;
import java.util.*;

public class Main {

    static int R, C, ans;
    static boolean visited[][];
    static int[][] arr;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    static class Node {
        int r,c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r,c));

        while(!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < 4; i++) {
                int tr = n.r + dr[i];
                int tc = n.c + dc[i];

                if(tr >= 0 && tr < R && tc >= 0 && tc < C && !visited[tr][tc] && arr[tr][tc]>0) {
                    q.offer(new Node(tr,tc));
                    arr[tr][tc] = arr[n.r][n.c] + 1;
                    visited[tr][tc] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(),"10",true);
            for (int j = 0; j < C; j++) {
                if(st.nextToken().equals("1")) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        visited[0][0] = true;
        bfs(0,0);

        bw.write(Integer.toString(arr[R-1][C-1]));
        bw.close();
        br.close();
    }
}