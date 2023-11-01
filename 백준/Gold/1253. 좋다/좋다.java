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

        for(int i = 0; i<N; i++) {
            int left = 0;
            int right = N-1;
            while(left < right) {
                if(left == i) {
                    left++;
                    continue;
                } else if(right == i) {
                    right--;
                    continue;
                }
                if(arr[left] + arr[right] < arr[i]) {
                    left++;
                } else if(arr[left] + arr[right] > arr[i]) {
                    right--;
                } else {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);

    }
}