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
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        } // 배열 다 받음

        for (int i = 0; i < N-1; i++) {
            boolean maxon = false;
            int maxidx = N-i-1; // 배열 중에 가장 큰 index
            for (int idx = 0; idx < N-i-1; idx++) {
                if(Arr[idx]>Arr[maxidx]) {
                    maxidx = idx;
                    maxon = true;
                }
            } // 가장 큰 index 이하의 요소들에서 max 찾음
            if(maxon) {
                int tmp = Arr[N - i - 1]; // 마지막 값 Arr[1]
                Arr[N - i - 1] = Arr[maxidx]; // 0,1 찾아서 맥스값을 Arr[1]에 넣음
                Arr[maxidx] = tmp;
                cnt++;
                if(K == cnt) {
                    for (int j = 0; j < N; j++) {
                        System.out.print(Arr[j]);
                        if(j==N-1) break;
                        System.out.print(" ");
                    }
                    break;
                }
            }
            if(i==N-2) {
                System.out.println(-1);
            }
        }

    }
}