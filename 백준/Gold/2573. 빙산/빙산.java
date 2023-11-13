import java.io.*;
import java.util.*;

public class Main {

    static int arr[][], N, M, max;
    static int dr[] = {1,-1,0,0};
    static int dc[] = {0,0,-1,1};
    static HashMap<Integer,Node> map = new HashMap<>();
    static boolean visit[][], notZero[][];
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 맵의 세로 줄 수
        M = Integer.parseInt(st.nextToken());   // 맵의 가로 줄 수
        notZero = new boolean[N][M];              // 방문 처리
        arr = new int[N][M];            // 빙산 값 배열


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;
                if (tmp != 0) {
                    notZero[i][j] = true;
                }
            }
        }       // 입력 완료

        int cnt = 0;
        while(true) {
            cnt++;
            check();        // 1년 동안 빙산 녹이기
            notZero = new boolean[N][M];       // Zero인지 다시 확인해야 하므로 초기화
            boolean isAllZero = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j] != 0) {        // 배열 값이 0이 아니라면
                        notZero[i][j] = true;   // Zero가 아니다에 체크
                        isAllZero = false;
                    }
                }
            }
            if(isAllZero) {
                System.out.println(0);
                return;
            }

            visit = new boolean[N][M];
            boolean moreThanTwice = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(!visit[i][j] && notZero[i][j]) {     // 방문 한적이 없고, 0이 아닌 수를 가지고 있을때
                        if(moreThanTwice) {         // 두번째 빙산이라면
                            System.out.println(cnt);    // 몇년 걸리는지 출력
                            return;
                        }
                        moreThanTwice = true;       // 다음번에 다시 조건에 걸리면 빙산 분리된 것
                        Node node = new Node(i,j);
                        bfs(node);      // 빙산 하나와 연결된 부분 전부 방문 처리
                    }
                }
            }
        }
    }

    public static void check() {
        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < M-1; j++) {
                if(notZero[i][j]) {         // 해당 인덱스가 0이 아니라면
                    int cnt = 0;            // 주변에 0인 블록 숫자
                    for (int k = 0; k < 4; k++) {
                        int tr = i+dr[k];
                        int tc = j+dc[k];
                        if(!notZero[tr][tc]) {      // 주변에 0이라면
                            cnt++;          // cnt + 1
                        }
                    }
                    arr[i][j] -= cnt;       // 빙산에 cnt만큼 빼주기
                    if(arr[i][j] < 0) {     // 만약 해당 인덱스 value가 음수라면 0으로 바꿔주기
                        arr[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void bfs(Node n) {
        Queue<Node> q = new LinkedList<>();
        q.add(n);       // 전달 받은 Node 큐에 넣기
        visit[n.r][n.c] = true;     // 방문처리

        while(!q.isEmpty()) {
            Node tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int tr = tmp.r + dr[i];
                int tc = tmp.c + dc[i];

                if(!visit[tr][tc] && notZero[tr][tc]) {     // 방문 한적 없는지, 0이 아닌 값을 가졌는지
                    visit[tr][tc] = true;               // 방문 처리
                    q.add(new Node(tr,tc));
                }
            }
        }
    }
}
