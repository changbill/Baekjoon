import java.io.*;
import java.util.*;



class Node {
    private int r;
    private int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}

public class Main {

    static int[][] Arr;
    static int N;
    static int cnt;
    static int[] delI;
    static int[] delJ;
    public static void delta(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + delI[i];
            int nc = c + delJ[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && Arr[nr][nc] == 1) {
                Arr[r][c] = 0;
                cnt++;
                delta(nr, nc);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Arr = new int[N][N];
        delI = new int[]{0, -1, 0, 1};
        delJ = new int[]{-1, 0, 1, 0};

        List<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(),"01", true);
            for (int j = 0; j < N; j++) {
                Arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if(Arr[i][j] == 1) {
                    cnt = 0;
                    Arr[i][j] = 0;
                    q.offer(new Node(i, j));
                    while(!q.isEmpty()) {
                        cnt++;
                        Node tmp = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nr = tmp.getR() + delI[k];
                            int nc = tmp.getC() + delJ[k];

                            if(nr>=0 && nr < N && nc >= 0 && nc < N && Arr[nr][nc] == 1) {
                                Arr[nr][nc] = 0;
                                q.offer(new Node(nr, nc));
                            }
                        }
                    }

                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        sb.append(list.size()+"\n");
        while(!list.isEmpty()) {
            sb.append(list.remove(0) + "\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}