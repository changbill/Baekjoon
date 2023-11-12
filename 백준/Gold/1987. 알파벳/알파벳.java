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

    static int dr[] = {1,-1,0,0};
    static int dc[] = {0,0,-1,1};
    static int R, C, max;
    static char alpha[][];
    static boolean visit[][];
    static HashMap<Character, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            alpha[i] = br.readLine().toCharArray();
        }       // 입력 완

        map.put(alpha[0][0],true);
        max = 0;            // 이동할 수 있는 최대 칸 수
        visit[0][0] = true;     // 방문처리
        dfs(0,0,1);

        System.out.println(max);
    }

    public static void dfs(int r, int c, int cnt) {
        for (int i = 0; i < 4; i++) {
            int tr = r + dr[i];
            int tc = c + dc[i];

            if(tr>=0 && tc >= 0 && tr<R && tc<C && !visit[tr][tc]) {    // 배열 범위 내에 있는지, 방문했었는지 확인

                if(map.containsKey(alpha[tr][tc])) {        // 해당 알파벳 받았던적이 있는지 확인
                    // 동일 알파벳이 있었다면 해당 칸에서 멈춤
                    max = Math.max(max, cnt);
                    continue;
                }

                map.put(alpha[tr][tc],true);        // 알파벳 받았음
                visit[tr][tc] = true;               // 방문처리
                dfs(tr,tc,cnt+1);               // 재귀 돌리기
                visit[tr][tc] = false;              // 해당 위치 방문 안한 경우의 수를 위해 방문처리 취소
                map.remove(alpha[tr][tc]);          // 해당 위치 방문 안한 경우의 수를 위해 알파벳 받은 것 취소
            }
        }
        max = Math.max(max, cnt);       // 방문 처리로 인해 dfs가 끝나는 경우 처리해주기
    }
}