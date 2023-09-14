import java.io.*;
import java.util.*;


class Node {
    private int r;
    private int c;
    private int cnt;
    private boolean destroy;

    public Node(int r, int c, int cnt, boolean destroy) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
        this.destroy = destroy;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getCnt() {
        return cnt;
    }

    public boolean isDestroy() {
        return destroy;
    }
}

public class Main {

    static boolean[][] Arr;
    static int[] delI;
    static int[] delJ;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Arr = new boolean[N][M];
        delI = new int[]{0, -1, 0, 1};
        delJ = new int[]{-1, 0, 1, 0};

        Queue<Node> nodes = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "01", true);
            for (int j = 0; j < M; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    Arr[i][j] = true;
                }
            }
        }

        nodes.offer(new Node(0, 0, 0, false));
        while(!nodes.isEmpty()) {
            Node tmp = nodes.poll();

            if(tmp.getR() == N-1 && tmp.getC() == M-1) {
                bw.write(Integer.toString(tmp.getCnt()+1));
                bw.close();
                br.close();
                return;
            }

            int nextCnt = tmp.getCnt()+1;
            for (int i = 0; i < 4; i++) {
                int nr = tmp.getR() + delI[i];
                int nc = tmp.getC() + delJ[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if(Arr[nr][nc]) {
                        if(!visited[nr][nc][0] && !tmp.isDestroy()) {
                            visited[nr][nc][1] = true;
                            nodes.offer(new Node(nr, nc, nextCnt, true));
                        }
                    } else {
                        if(!visited[nr][nc][0] && !tmp.isDestroy()) {
                            visited[nr][nc][0] = true;
                            nodes.offer(new Node(nr, nc, nextCnt, tmp.isDestroy()));
                        } else if(!visited[nr][nc][1] && tmp.isDestroy()) {
                            visited[nr][nc][1] = true;
                            nodes.offer(new Node(nr, nc, nextCnt, tmp.isDestroy()));
                        }
                    }
                }
            }

        }

        bw.write(Integer.toString(-1));
        bw.close();
        br.close();
    }
}