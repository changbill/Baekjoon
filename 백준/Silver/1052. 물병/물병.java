import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = 0;
        int tmp = N;
        while(tmp != 0) {
            int cnt = 0;
            for (int i = 0; i < 25; i++) {
                if((tmp & (1<<i)) > 0) {
                    cnt++;
                }
            }
            if(cnt<=K) {
                break;
            }
            tmp++;
            ans++;
        }

        bw.write(Integer.toString(ans));
        br.close();
        bw.close();
    }
}