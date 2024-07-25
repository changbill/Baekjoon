import java.io.*;
import java.util.*;

public class Main {
    static int MAX_VALUE = 4_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean arr[] = new boolean[MAX_VALUE+1];
        int cnt = 0;
        // false : 소수
        // true : 소수 X
        arr[1] = true;
        for(int i = 2; i <= MAX_VALUE; i++) {
            if(arr[i]) continue;
            int tmp = 2;
            cnt++;
            while(i*tmp <= MAX_VALUE) {
                int idx = i * tmp++;
                arr[idx] = true;
            }
        }

        int sumArr[] = new int[cnt+1];
        int idx = 1;
        for(int i = 2; i <= MAX_VALUE; i++) {
            if(!arr[i]) {
                sumArr[idx] = sumArr[idx-1] + i;
                ++idx;
            }
        }

        int N = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        int sum = 0;
        int result = 0;
        while(end <= cnt) {
            sum = sumArr[end] - sumArr[start-1];
            if(sum == N) {
                result++;
                start++;
                if(start > end) {
                    end++;
                }
            } else if(sum < N) {
                end++;
            } else {
                start++;
                if(start > end) {
                    end++;
                }
            }
        }

        System.out.println(result);

    }
}