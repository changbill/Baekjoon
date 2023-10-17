
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int dr[] = {1,-1,0,0};
    static int dc[] = {0,0,-1,1};
    static int N, blindCnt, colorCnt;
    static char arr[][];
    static boolean bvisit[][],cvisit[][];
    static class Node{
        int r,c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        } // 입력 완

        bvisit = new boolean[N][N];
        cvisit = new boolean[N][N];
        blindCnt = 0;
        colorCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Node node = new Node(i, j);
                if(!bvisit[i][j]) blind(node);
                if(!cvisit[i][j]) color(node);
            }
        }

        sb.append(colorCnt+" "+blindCnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void color(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int r = node.r;
        int c = node.c;
        cvisit[r][c] = true;

        char color;
        if(arr[r][c] == 'R') {
            color = 'R';
        } else if(arr[r][c] == 'G') {
            color = 'G';
        } else {
            color = 'B';
        }

        while(!q.isEmpty()) {
            Node tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int tr = tmp.r + dr[i];
                int tc = tmp.c + dc[i];

                // 배열 범위 확인, 방문 여부 확인, 색이 동일한지 확인
                if(tr >= 0 && tr < N && tc >= 0 && tc < N && !cvisit[tr][tc] && arr[tr][tc] == color) {
                    cvisit[tr][tc] = true;
                    q.add(new Node(tr,tc));
                }
            }
        }
        colorCnt++;
    }

    public static void blind(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int r = node.r;
        int c = node.c;
        bvisit[r][c] = true;

        if(arr[r][c] == 'R' || arr[r][c] == 'G') {
            while(!q.isEmpty()) {
                Node tmp = q.poll();
                for (int i = 0; i < 4; i++) {
                    int tr = tmp.r + dr[i];
                    int tc = tmp.c + dc[i];

                    // 배열 범위 확인, 방문 여부 확인, 색이 동일한지 확인
                    if(tr >= 0 && tr < N && tc >= 0 && tc < N && !bvisit[tr][tc] && (arr[tr][tc] == 'R' || arr[tr][tc] == 'G')) {
                        bvisit[tr][tc] = true;
                        q.add(new Node(tr,tc));
                    }
                }
            }
        } else {
            while(!q.isEmpty()) {
                Node tmp = q.poll();
                for (int i = 0; i < 4; i++) {
                    int tr = tmp.r + dr[i];
                    int tc = tmp.c + dc[i];

                    // 배열 범위 확인, 방문 여부 확인,
                    if(tr >= 0 && tr < N && tc >= 0 && tc < N && !bvisit[tr][tc] && arr[tr][tc] == 'B') {
                        bvisit[tr][tc] = true;
                        q.add(new Node(tr,tc));
                    }
                }
            }
        }

        blindCnt++;
    }
}
