import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    // 반시계 방향 북서남동
    static int dx[] = { -1, 0, 1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static boolean cleaned[][];
    static int N, M, arr[][], cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        cleaned = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        cnt = 0;
        dfs(r, c, dir);
        System.out.println(cnt);
    }

    public static void dfs(int r, int c, int dir) {
        if (!cleaned[r][c]) {
            cnt++;
            cleaned[r][c] = true;
        }

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int dr = r + dx[dir];
            int dc = c + dy[dir];

            if (arr[dr][dc] == 1 || cleaned[dr][dc]) {
                continue;
            }

            dfs(dr, dc, dir);
            return;
        }

        int d = (dir + 2) % 4;
        int dr = r + dx[d];
        int dc = c + dy[d];
        if (arr[dr][dc] == 1) {
            return;
        }

        dfs(dr, dc, dir);
    }
}
