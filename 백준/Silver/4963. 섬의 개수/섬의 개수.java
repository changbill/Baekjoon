import java.io.*;
import java.util.*;

public class Main {

    static int W, H, cnt, tmpH, tmpW, th, tw;
    static boolean visited[][], arr[][];
    static class Node {
        int h, w;
        Node(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
    static int dr[] = {1,-1,0,0,1,1,-1,-1};
    static int dc[] = {0,0,1,-1,1,-1,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        while (true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            cnt = 0;
            if(W == 0 && H == 0) {
                break;
            }

            arr = new boolean[H][W];
            visited = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    if(Integer.parseInt(st.nextToken()) == 1) arr[i][j] = true;
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if(arr[i][j] && !visited[i][j]) {
                        bfs(i,j);
                    }
                }
            }

            sb.append(cnt+"\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void bfs(int h, int w) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(h,w));
        visited[h][w] = true;

        while(!q.isEmpty()) {
            Node n = q.poll();
            th = n.h;
            tw = n.w;
            for (int i = 0; i < 8; i++) {
                tmpH = th + dr[i];
                tmpW = tw + dc[i];

                if(tmpH < H && tmpW < W && tmpH >= 0 && tmpW >= 0 && !visited[tmpH][tmpW] && arr[tmpH][tmpW]) {
                    q.add(new Node(tmpH,tmpW));
                    visited[tmpH][tmpW] = true;
                }
            }
        }

        cnt++;
    }
}