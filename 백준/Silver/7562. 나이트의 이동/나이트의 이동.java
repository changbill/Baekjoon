import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int dr[] = {1,2,2,1,-1,-2,-2,-1};
    static int dc[] = {2,1,-1,-2,-2,-1,1,2};
    static int arr[][], l;
    static boolean visited[][];
    static StringBuilder sb;

    static class Node{
        int r,c,cnt;
        Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            l = Integer.parseInt(br.readLine());
            arr = new int[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            int nr = Integer.parseInt(st.nextToken());
            int nc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int gr = Integer.parseInt(st.nextToken());
            int gc = Integer.parseInt(st.nextToken());

            arr[gr][gc] = 1;

            if(gr == nr && gc == nc) {
                sb.append(0 + "\n");
                continue;
            }

            bfs(nr,nc);
        }
        System.out.println(sb.toString());
    }

    public static void bfs(int nr, int nc) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(nr,nc, 0));
        visited[nr][nc] = true;

        while(!q.isEmpty()) {
            Node n = q.poll();

            for (int i = 0; i < 8; i++) {
                int r = n.r + dr[i];
                int c = n.c + dc[i];
                int cnt = n.cnt;

                if(r>=0 && r < l && c >=0 && c < l && !visited[r][c]) {
                    if(arr[r][c] == 1) {
                        sb.append(cnt+1+"\n");
                        return;
                    }
                    visited[r][c] = true;
                    q.add(new Node(r,c,cnt+1));
                }
            }
        }
    }
}
