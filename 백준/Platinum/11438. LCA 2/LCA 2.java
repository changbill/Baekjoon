import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] edge;
    static boolean flag[];
    static int d[], p[][], N, M, K;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        edge = new List[N+1];
        for(int i = 0; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            edge[U].add(V);
            edge[V].add(U);
        }

        M = Integer.parseInt(br.readLine());

        searchMaxDepth();

        flag = new boolean[N+1];
        d = new int[N+1];
        p = new int[N+1][K+1];

        dfs(1, 0);
        fillParent();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int descA = Integer.parseInt(st.nextToken());
            int descB = Integer.parseInt(st.nextToken());

            lca(descA, descB);
        }

        System.out.println(sb);
    }

    // 정확히는 depth를 구하는 것이 아닌 log2로 로그 계산했을 때 트리의 최대 깊이를 구하는 것
    // 이를 구하는 이유는 dp에 1,2,4,8처럼 2의 제곱수의 결과를 저장하기 위해 배열 초기화를 할 때 최대값이 필요하기 때문
    static void searchMaxDepth() {
        K = (int) Math.ceil(Math.log(N)/Math.log(2));
    }

    static void dfs(int parent, int depth) {
        d[parent] = depth;
        flag[parent] = true;

        for(int child : edge[parent]) {
            if(!flag[child]) {
                p[child][0] = parent;
                dfs(child, depth + 1);
            }
        }
    }

    // dp 배열 채우는 함수
    static void fillParent() {
        for(int i = 1; i <= K; i++) {
            for(int j = 1; j <= N; j++) {
                p[j][i] = p[p[j][i-1]][i-1];     // 2^i번째 부모 저장
            }
        }
    }

    /**
     * lca : 가장 가까운 공통 조상 구하는 함수
     * @param descA : 1번째 정점 번호
     * @param descB : 2번째 정점 번호
     */
    static void lca(int descA, int descB) {
        int depthA = d[descA];
        int depthB = d[descB];

        if(depthA < depthB) {   
            int tmp = descA;
            descA = descB;
            descB = tmp;
        }       // A의 depth가 B보다 더 높도록 조정

        for(int i = K; i >= 0; i--) {
            if(Math.pow(2, i) <= d[descA] - d[descB]) {
                descA = p[descA][i];
            }
        }       // depth A == B 완료

        if(descA == descB) {
            sb.append(descA + "\n");
            return;
        }       // 이대로 공통조상이라면 return

        // 2의 제곱수만큼 공통조상에 가까워지는 함수. 이진수에서 가장 왼쪽에 있는 1부터 지워나간다고 생각하면 쉽다.
        for(int i = K; i >= 0; i--) {
            if(p[descA][i] != p[descB][i]) {
                descA = p[descA][i];
                descB = p[descB][i];
            }
        }       

        // p[descA][0] == p[descB][0]인 상태이므로 descA가 아닌 부모를 출력
        sb.append(p[descA][0] + "\n");
    }
}