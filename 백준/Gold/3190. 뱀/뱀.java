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

    static int dr[] = {0, 1, 0, -1};
    static int dc[] = {1, 0, -1, 0};    // 오른쪽, 아래쪽, 왼쪽, 위쪽 순
    static int dirIdx = 0;
    static int N, K, ans;
    static int map[][];
    static Node cur;
    static Queue<Node> q = new LinkedList<>();
    static boolean[][] flag;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // 보드의 크기
        K = Integer.parseInt(br.readLine());    // 사과의 개수
        map = new int[N + 2][N + 2];
        flag = new boolean[N + 2][N + 2];

        for (int i = 0; i < N + 2; i++) {
            map[0][i] = -1;
            map[i][0] = -1;
            map[i][N + 1] = -1;
            map[N + 1][i] = -1;
        }

        for (int k = 1; k <= K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
        }

        ans = 0;
        cur = new Node(1, 1);
        q.add(cur);
        flag[cur.r][cur.c] = true;
        int L = Integer.parseInt(br.readLine());    // 뱀의 방향 변환 횟수
        for (int l = 1; l <= L; l++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()) - ans;   // 이동 횟수
            char rotateChar = st.nextToken().charAt(0);

            if(!move(X, rotateChar)) break;
            if(l == L) move(101, 'L');
        }

        System.out.println(ans);
    }

    private static boolean move(int moveCnt, char rotateChar) {
        int newRow = cur.r;
        int newCol = cur.c;
        int newCnt = moveCnt;

        while (newCnt > 0) {
            newRow += dr[dirIdx];
            newCol += dc[dirIdx];
            newCnt--;

            if (map[newRow][newCol] == -1) {    // 벽에 부딪혀 게임 끝
                ans += moveCnt - newCnt;
                return false;
            }

            if (flag[newRow][newCol]) {  // 몸에 부딪혀 게임 끝
                ans += moveCnt - newCnt;
                return false;
            }

            cur = new Node(newRow, newCol);
            q.add(cur);
            flag[newRow][newCol] = true;
            if (map[newRow][newCol] == 0) {   // 사과 없음
                Node rNode = q.remove();
                flag[rNode.r][rNode.c] = false;
            } else {
                map[newRow][newCol] = 0;
            }
        }

        if(rotateChar == 'L') {
            if(--dirIdx < 0) dirIdx = 3;
        } else {
            if(++dirIdx > 3) dirIdx = 0;
        }

        ans += moveCnt - newCnt;
        return true;
    }
}