import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, arr[],valArr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        valArr = new int[N];
        valArr[0] = arr[0];
        int maxIdx = 0;
        for (int i = 1; i < N; i++) {
            if(arr[i] > valArr[maxIdx]) {
                valArr[++maxIdx] = arr[i];
            } else {
                int valIdx = binarySearch(maxIdx, i); // 바꿀 valArr의 인덱스
                valArr[valIdx] = arr[i];
            }
        }
        System.out.println(maxIdx+1);
    }

    public static int binarySearch(int maxIdx, int arrIdx) {
        int lo = 0;
        int hi = maxIdx;
        while(lo < hi) {
            int mid = (lo + hi)/2;
            if(valArr[mid] < arr[arrIdx]) {     // 찾을 값보다 작다면
                lo = mid + 1;
            } else {                            // 찾을 값보다 크거나 같다면
                hi = mid;
            }
        }
        return lo;
    }
}