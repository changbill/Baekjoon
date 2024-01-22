import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static long max[], min[], arr[];
    static PriorityQueue<Long> maxPq = new PriorityQueue<>();
    static PriorityQueue<Long> minPq = new PriorityQueue<>();
    // max : 최대값
    // min : 최소값

    // start, end : 0~11 (루트노드 인덱스)
    // node : 1~29 (모든 노드 인덱스)
    static long maxInit(int start, int end, int node) {
        // 루트 노드라면
        if(start == end) {
            return max[node] = arr[start];
        }

        // 구간 max 구하기
        int mid = (start+end)/2;
        return max[node] = Math.max(maxInit(start, mid, node*2),maxInit(mid+1, end, node*2+1));
    }

    static long minInit(int start, int end, int node) {
        // 루트 노드라면
        if(start == end) {
            return min[node] = arr[start];
        }

        // 구간 min 구하기
        int mid = (start+end)/2;
        return min[node] = Math.min(minInit(start, mid, node*2), minInit(mid+1, end, node*2+1));
    }

    // start : 시작 인덱스
    // end : 끝 인덱스
    // left, right : 구하려는 구간 합 범위
    static Long findMax(int start, int end, int node, int left, int right) {
        // 범위 밖에 있는 경우
        if(left > end || right < start)
            return Long.MIN_VALUE;

        // 범위 안에 있는 경우
        // 구간 max 반환
        if(left <= start && right >= end)
            return max[node];

        int mid = (start+end)/2;
        // 범위 중 어떤부분은 포함되어 있고 어떤 부분은 제외되어 있다면 이분탐색으로 나누어 max 구하기
        return Math.max(findMax(start,mid,node*2,left,right), findMax(mid+1,end,node*2+1,left,right));
    }

    static Long findMin(int start, int end, int node, int left, int right) {
        // 범위 밖에 있는 경우
        if(left > end || right < start)
            return Long.MAX_VALUE;

        // 범위 안에 있는 경우
        // 구간 max 반환
        if(left <= start && right >= end)
            return min[node];

        int mid = (start+end)/2;
        // 범위 중 어떤부분은 포함되어 있고 어떤 부분은 제외되어 있다면 이분탐색으로 나누어 min 구하기
        return Math.min(findMin(start,mid,node*2,left,right), findMin(mid+1,end,node*2+1,left,right));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new long[N+1];
        max = new long[N*4];
        min = new long[N*4];
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        maxInit(1, N, 1);
        minInit(1,N,1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(findMin(1,N,1,a,b)+" "+findMax(1,N,1,a,b)+"\n");
        }

        System.out.println(sb.toString());
    }
}