import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long M, arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        arr = new long[N];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
            if(min > tmp) {
                min = tmp;
            }
        }

        long lo = 1;
        long hi = min*M;

        int ans = 0;
        while(lo < hi) {
            long mid = lo + (hi-lo)/2;           // 시간 기준으로 이분 탐색 할 것임
            long people = 0;                     // 심사 받은 사람수
            for (int i = 0; i < N; i++) {
                people += mid/arr[i];
            }

            if(people >= M) {                    // 더 많은 사람들이 심사대에 통과할 수 있다
                hi = mid;                     // 시간을 줄여보자
            } else {                            // 우리 다 통과 못했는데
                lo = mid+1;                    // 시간을 늘려보자
            }
        }

        System.out.println(hi);
    }
}