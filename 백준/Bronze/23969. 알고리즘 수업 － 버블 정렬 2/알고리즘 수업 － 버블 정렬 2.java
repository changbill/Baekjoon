import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] Arr = new int[N];
        int idx = 0; // 교환횟수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        loop:
        while(true) {
            // 초기값
            int val = idx;
            // 오름차순 변환 한 사이클
            for (int i = 0; i < N - 1; i++) {
                if(Arr[i] > Arr[i+1]) {
                    int tmp = Arr[i];
                    Arr[i] = Arr[i+1];
                    Arr[i+1] = tmp;
                    idx++;
                    if(idx == K) {
                        for (int j = 0; j < N; j++) {
                            System.out.print(Arr[j]);
                            if(j==N-1) break;
                            System.out.print(" ");
                        }
                        break loop;
                    }
                }

                if (i==N-2 && idx-val == 0) { // 초기값과 교환횟수 비교
                        System.out.println(-1);
                        break loop;
                }
            }
        }
    }
}