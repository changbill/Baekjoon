import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] Arr = new int[2000001];
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Arr[Integer.parseInt(br.readLine())+1000000]++;
        }
        // StringBuilder로 출력
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<2000001; i++) {
            if(Arr[i]>=1) {
                while(Arr[i]>0) {
                    sb.append(i-1000000).append("\n");
                    Arr[i]--;
                }
            }
        }
        System.out.println(sb);
    }
}