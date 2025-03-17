import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int dr[] = {0,0,-1,1};
    static int dc[] = {1,-1,0,0};
    static int N, L, R;
    static int map[][], copyMap[][];
    static boolean visited[][];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // N*N 크기의 땅
        map = new int[N+1][N+1];
        copyMap = new int[N+1][N+1];
        L = Integer.parseInt(st.nextToken());       // 인구 차이 L이상 R이하인 경우 인구 이동
        R = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++) {
                int i1 = Integer.parseInt(st.nextToken());
                map[i][j] = i1;
                copyMap[i][j] = i1;
            }
        }

        int cnt = 0;
        while(true) {
            visited = new boolean[N+1][N+1];
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        populationMove(bfs(i, j));
                    }
                }
            }

            boolean flag = false;
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(map[i][j] != copyMap[i][j]) {
                        flag = true;
                        map[i][j] = copyMap[i][j];
                    }
                }
            }

            if(!flag) {
                break;        // 인구 이동이 없다면 반복 끝
            } else {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void populationMove(List<Node> nodes) {
        int sum = 0;
        for(int i = 0; i < nodes.size(); i++) {
            Node n = nodes.get(i);
            sum += copyMap[n.r][n.c];
        }

        int val = sum / nodes.size();
        for(int i = 0; i < nodes.size(); i++) {
            Node n = nodes.get(i);
            copyMap[n.r][n.c] = val;
        }
    }

    private static List<Node> bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        Node e = new Node(i, j);
        List<Node> res = new ArrayList<>();
        res.add(e);
        q.add(e);

        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(int k = 0; k < 4; k++) {
                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];

                if(nr > 0 && nc > 0 && nr <= N && nc <= N && !visited[nr][nc]) {
                    int temp = Math.abs(map[nr][nc] - map[cur.r][cur.c]);
                    if(temp >= L && temp <= R) {
                        Node node = new Node(nr, nc);
                        q.add(node);
                        res.add(node);
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return res;
    }
}