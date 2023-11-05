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
        }       // 입력 완

        valArr = new int[N];                // 가장 긴 증가하는 부분 수열 값을 넣을 배열
        valArr[0] = arr[0];                 // 0번째 인덱스에는 arr[0] 넣기
        int maxIdx = 0;                     // 현재 가장 큰 인덱스는 0임
        for (int i = 1; i < N; i++) {
            if(arr[i] > valArr[maxIdx]) {       // arr의 해당 인덱스 값이 valArr의 가장 큰 값보다 크다면
                valArr[++maxIdx] = arr[i];      // 새로운 인덱스에 해당 값 넣기
            } else {
                int valIdx = binarySearch(maxIdx, i);
                valArr[valIdx] = arr[i];        // valArr 해당 인덱스 갈아치우기
                // 갈아치우는 값은 그 이상의 값이지만 arr[i]값에 가장 가까운 값이다.
                // 이 값은 이미 앞에서 구했던 배열에는 영향을 주지 않고 앞으로 구할 값들에만 영향을 주므로 문제되지 않는다
            }
        }
        System.out.println(maxIdx+1);
    }

    // 갈아치울 valArr의 인덱스 구하기
    public static int binarySearch(int maxIdx, int arrIdx) {
        int lo = 0;
        int hi = maxIdx;
        // 우리가 구하려는 인덱스는 같은값 이상의 해당 값에 가장 가까운 값
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