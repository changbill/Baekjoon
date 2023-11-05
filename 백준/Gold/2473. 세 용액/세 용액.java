import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long arr[] = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }                   // 입력 완

        Arrays.sort(arr);   // 정렬

        long min = Long.MAX_VALUE;
        int one = 0;
        int two = 0;
        int thr = 0;
        for (int i = 0; i < N - 2; i++) {
            int lo = i+1;
            int hi = N-1;
            while(lo < hi) {
                long sum = arr[i]+arr[lo]+arr[hi];

                if(Math.abs(min) > Math.abs(sum)) {
                    min = sum;
                    one = i;
                    two = lo;
                    thr = hi;
                }

                if(sum < 0) {
                    lo++;
                } else if(sum >0) {
                    hi--;
                } else {
                    System.out.println(arr[i]+" "+arr[lo]+" "+arr[hi]);
                    return;
                }

            }
        }

        System.out.println(arr[one] + " " + arr[two] + " " + arr[thr]);
    }
}