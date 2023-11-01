import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int cnt, N, arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());                // N개의 수
        arr = new int[N];                                   // 담는 배열
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }   // 입력 완

        Arrays.sort(arr);           // 정렬

        // 투 포인터
        for(int i = 0; i<N; i++) {
            int left = 0;                   // 왼쪽 포인터
            int right = N-1;                // 오른쪽 포인터 
            while(left < right) {           // 왼쪽 포인터보다 오른쪽이 큰데까지만
                if(left == i) {             // 만일 구하는 값과 동일한 인덱스라면
                    left++;                 // 넘어간다
                    continue;
                } else if(right == i) {
                    right--;
                    continue;
                }
                if(arr[left] + arr[right] < arr[i]) {   // 두 포인터의 합이 구하려는 값보다 작다면
                    left++;                             // 왼쪽 포인터를 +1해준다 ( 더 큰 값으로)
                } else if(arr[left] + arr[right] > arr[i]) { // 두 포인터의 합이 구하려는 값보다 크다면
                    right--;                                // 오른쪽 포인터를 -1해준다 ( 더 작은 값으로)
                } else {                                // 두 포인터의 합이 구하려는 값과 동일하다면
                    cnt++;                              // cnt + 1
                    break;
                }
            }
        }

        System.out.println(cnt);

    }
}