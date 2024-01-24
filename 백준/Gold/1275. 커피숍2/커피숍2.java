import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] tree, arr;
    // start, end : 0~11 (루트노드 인덱스)
    // node : 1~29 (모든 노드 인덱스)
    static long init(int start, int end, int node) {
        // 리프 노드라면
        if(start == end) {
            return tree[node] = arr[start];
        }

        // 구간 합 구하기
        int mid = (start + end) /2;
        return tree[node] = init(start, mid, node * 2) + init(mid+1, end, node*2+1);
    }


    // start : 시작 인덱스
    // end : 끝 인덱스
    // left, right : 구하려는 구간 합 범위
    static long sum(int start, int end, int node, int left, int right) {
        // 범위 밖에 있는 경우
        if(left > end || right < start) {
            return 0;
        }

        // 범위 안에 있는 경우
        // 구간 합을 더한다
        if(left <= start && right >= end) {
            return tree[node];
        }

        // 범위 중 어떤부분은 포함되어 있고 어떤 부분은 제외되어 있다면 이분탐색으로 나누어 곱 구하기
        int mid = (start + end) /2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }

    // start : 시작 인덱스
    // end : 끝 인덱스
    // index : 수정하고자 하는 노드
    // dif : 수정할 값
    static void update(int start, int end, int node, int index, long val) {
        // 수정 인덱스가 범위 밖에 있는 경우
        if(index > end || index < start) {
            return;
        }

        // 리프 노드라면
        if(start == end) {
            tree[node] = val;
            return;
        }

        // 수정 인덱스가 범위 안에 있으면 내려가며 다른 원소도 갱신
        // ex) 0~11, 6~11, 6~8, 6~7, 7
        // 구간 합 update
        tree[node] += val-arr[index];
        int mid = (start + end) /2;
        update(start,mid,node*2,index,val);
        update(mid+1,end,node*2+1,index,val);
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new long[N+1];
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        tree = new long[N*4];
        init(1,N,1);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());

            if(x<y) {
                sb.append(sum(1,N,1,x,y) + "\n");
            } else {
                sb.append(sum(1,N,1,y,x) + "\n");
            }

            update(1,N,1,a,b);
            arr[a] = b;
        }

        System.out.println(sb.toString());
    }
}