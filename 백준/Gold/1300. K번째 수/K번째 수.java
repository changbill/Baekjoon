import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long left = 1;
        long right = k;
        while(left < right) {
            long mid = (right - left) / 2 + left;
            long sum = 0;
            for(int i = 1; i <= N; i++) {
                sum += Math.min(mid/i, N);
            }
            if(sum < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left);
    }
}