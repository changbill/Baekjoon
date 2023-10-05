import java.io.*;
import java.util.*;

public class Main {

    static int arr[][], k, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 지폐의 금액
        k = Integer.parseInt(br.readLine()); // 동전의 가지 수
        arr = new int[k][2]; // 동전 종류마다 가치와 몇개 있는지 arr
        int[] dp = new int[T+1]; // 해당 금액에서 동전 교환 방법의 수

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 동전 가치
            arr[i][1] = Integer.parseInt(st.nextToken()); // 동전 몇개 가졌는지
        }

        // 동전 교환 가지수 구하는 것
        dp[0] = 1; // 1부터 시작

        for (int i = 0; i < k; i++) {
            int val = arr[i][0]; // 해당 동전 가치
            // 지폐 금액부터 즉, 높은 금액부터 낮은 금액으로 찾는 이유는 반대의 경우 중복이 일어나기 때문
            // 반대의 경우 각 금액에서 해당금액으로 만드는 가지 수를 나타내는 dp 배열이 됨
            for (int j = T; j >= val; j--) { // 동전 쓸 수 있을 때부터 지폐 금액까지 따져보기
                for (int l = 1; l <= arr[i][1]; l++) { // 동전 개수
                    if(j- val*l <0) break; // 동전 개수 * 동전 가치 보다 작다면
                    dp[j] += dp[j-val*l]; // l개 만큼의 동전 개수를 통해 해당 금액(j)를 만들 수 있음
                }
            }
        }

        bw.write(Integer.toString(dp[T]));
        bw.flush();
        bw.close();
        br.close();

    }
}