import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 반시계 방향 북서남동
    static int dr[] = {0, -1, 0 };
    static int dc[] = { -1, 0, 1 };
    static int N, M, D, max, arr[][];
    static boolean arc[];
    static class Node {
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

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 맵의 행 수
        M = Integer.parseInt(st.nextToken()); // 맵의 열 수
        arr = new int[N+1][M]; // 맵
        D = Integer.parseInt(st.nextToken()); // 궁수의 공격 거리 제한
        arc = new boolean[M]; // 궁수 위치 선정

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완

        max = Integer.MIN_VALUE;
        dfs(0, 0); // 궁수 위치 선정
        System.out.println(max); // 제거할 수 있는 적의 최대 수
    }

    public static void dfs(int idx, int cnt) { // 궁수 위치 정하기
        if(cnt == 3) { // 궁수 3명 위치 선정 완료
            bfs(); // 게임 시작
            return;
        }

        for(int i = idx; i<M; i++) {
            arc[i] = true; // 궁수 1명 위치 선정
            dfs(i+1, cnt+1); // 중복 불가하므로 i+1, 한명 구했으므로 cnt +1
            arc[i] = false; // 재귀 빠져나왔을 때
        }
    }

    public static void bfs() { // 궁수가 공격할 대상 찾기
        int ans = 0; // 적 제거한 수
        int arrclone[][] = new int[N+1][M]; // arr 복사본
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arrclone[i][j] = arr[i][j]; // arr 복사
            }
        }

        while(true) { // 공격, 적 전진 한 사이클 돌때마다 다시 반복
            int idx = 0; // 궁수 공격 대상 배열 인덱스
            Node kill[] = new Node[3]; // 죽일 적 위치

            // 궁수 1,2,3 화살 쏠 적 찾기
            loop:
            for (int i = 0; i < M; i++) { // 궁수 1,2,3
                if (arc[i]) { // 궁수 위치라면
                    Queue<Node> q = new LinkedList<>(); // 새로운 BFS 시작할 때마다 Queue 초기화
                    q.add(new Node(N, i)); // queue에 성 바로 앞 위치 넣기
                    boolean visit[][] = new boolean[N][M]; // 새로운 BFS 시작할때마다 방문처리 배열 초기화

                    while (!q.isEmpty()) {
                        Node tmp = q.poll();
                        // queue 첫번째 위치에 있는 적을 발견 못한다


                        for (int j = 0; j < 3; j++) { // 왼쪽, 위쪽, 오른쪽
                            int tr = tmp.r + dr[j]; // 델타 적용
                            int tc = tmp.c + dc[j];

                            if(Math.abs(tr-N) + Math.abs(tc-i) > D) continue loop; // 궁수 공격거리 제한을 벗어나면 그만 찾기
                            if (tr >= 0 && tc >= 0 && tc < M && tr < N &&!visit[tr][tc]) { // 배열 범위 지켰는지, 방문했었는지
                                if (arrclone[tr][tc] == 1) { // 적이 있다면
                                    kill[idx++]= new Node(tr,tc); // 적 위치 입력
                                    continue loop; // 다음 궁수로 넘어가기
                                } else { // 적이 없다면 BFS 진행
                                    visit[tr][tc] = true; // 방문 처리
                                    q.add(new Node(tr, tc));
                                }
                            }
                        }

                    }
                }
            }

            for (int i = 0; i < 3; i++) { // 동시에 쏴서 제거
                Node tmp = kill[i];
                if(tmp == null) continue;
                if(arrclone[tmp.r][tmp.c] == 1) {
                    arrclone[tmp.r][tmp.c] = 0;
                    ans++;
                }
            }

            // 공격 끝나고 적 한칸씩 전진
            for (int i = N - 1; i >= 0; i--) {
                for (int j = 0; j < M; j++) {
                    arrclone[i + 1][j] = arrclone[i][j];
                    if (i == 0) { // 행이 0번째일 때는
                        arrclone[i][j] = 0; // 전부 한칸씩 이동했으므로 행 전체에 0 입력
                    }
                }
            }

            loop2:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arrclone[i][j] == 1) { // 적이 아직 맵에 남아있다면
                        break loop2; // 반복
                    }
                }
                if (i == N - 1) { // 적이 한명도 없다면
                    max = Math.max(max, ans); // 죽인 적 최대 구하기
                    return;
                }
            }
        }
    }
}
