import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long LIS[];
    static int maxIdx, dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long arr[] = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        LIS = new long[N];                   // 가장 긴 증가하는 부분 수열
        dp = new int[N];                    // 인덱스 담는 dp
        dp[0] = 0;
        maxIdx = 0;                         // 현재 가장 높은 값은 0번째 인덱스
        LIS[0] = arr[0];                    // 0번째 인덱스는 arr[0] 고정이므로 할당
        for (int i = 1; i < N; i++) {
            if(LIS[maxIdx] < arr[i]) {      // 최대값 갱신 시
                maxIdx++;                   // 새로운 인덱스에
                LIS[maxIdx] = arr[i];       // 최대값 할당
                dp[i] = maxIdx;             // i번째 인덱스 dp값은 maxIdx
            } else if(LIS[maxIdx] > arr[i]){            // 이미 나온 값들 범위 내에 있을 경우
                int tmpIdx = binarySearch(arr[i]);      // arr[i]보다 같거나 그 이상 인덱스 찾기
                LIS[tmpIdx] = arr[i];                   // 해당 인덱스에 arr[i] 대체
                dp[i] = tmpIdx;                         // i번째 인덱스 dp값은 해당 인덱스
            } else {                        // 최대값과 같다면
                dp[i] = maxIdx;             // i번째 인덱스 dp값은 최대값 인덱스
            }
        }

        int idx = maxIdx;
        long ans[] = new long[maxIdx+1];
        for (int i = N-1; i >= 0; i--) {
            if(dp[i] == idx) {
                ans[idx] = arr[i];
                idx--;
            }
        }
        sb.append((maxIdx+1)+"\n");
        for (int i = 0; i <= maxIdx; i++) {
            sb.append(ans[i]+" ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();

        // dp와 LIS 함께 구하여 dp max값부터 -1씩 가장 오른쪽에서부터 탐색 O(N)

    }

    public static int binarySearch(long val) {
        int lo = 0;
        int hi = maxIdx;
        while(lo < hi) {
            int mid = (lo+hi)/2;
            if(LIS[mid] < val) {            // mid와 비교했을 때 원하는 값보다 작아서
                lo = mid+1;                 // 왼쪽 포인터를 mid+1로 올린다
            } else {                        // mid와 비교했을 때 원하는 값보다 높거나 같아서
                hi = mid;                   // 오른쪽 포인터를 mid로 내린다
            }
        }
        return hi;
    }
}