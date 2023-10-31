
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;

            if(max < tmp) {
                max = tmp;
            }

        }

        int M = Integer.parseInt(br.readLine());

        int lo = 1;
        int hi = max;
        int ans = 0;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;           // 상한액
            int budget = 0;
            for (int i = 0; i < N; i++) {
                if(arr[i] > mid) {
                    budget += mid;
                    continue;
                }
                budget += arr[i];
            }
            if(M < budget) {
                hi = mid-1;
            } else if(M > budget) {
                lo = mid+1;
            } else {
                ans = mid;
                break;
            }
        }

        if(ans == 0) {
            ans = hi;
        }

        System.out.println(ans);
    }
}
