import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] NArr = new int[N+1];

        int idx = 1;
        NArr[1] = 1;
        int cnt = 0;
        while(NArr[idx] <M) {
            if(NArr[idx]%2 == 0) { // 공을 받은 횟수가 짝수면
                idx -= L;

                if(idx <= 0) { // 3/-2 == -1 --> 내림
                    idx += -(idx/N - 1)*N;
                }

            } else { // 공을 받은 횟수가 홀수면
                idx += L;

                if(idx > N) {
                    idx -= N*(idx/N);
                }

            }

            NArr[idx]++;
            cnt++;
        }


        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();
    }
}