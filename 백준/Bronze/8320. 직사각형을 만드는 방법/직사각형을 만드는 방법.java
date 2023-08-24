import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= Math.sqrt(n); i++) {
            for (int j = i; j*i <= n; j++) {
                if(i*j > n) {
                    break;
                }
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}