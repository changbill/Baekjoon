import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] Arr = new int[1002][1002];

        int N = Integer.parseInt(br.readLine());
        for (int n = 1; n <= N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for (int i = x; i < x+w; i++) {
                for (int j = y; j < y+h; j++) {
                    Arr[j][i] = n;
                }
            }


        }

        for (int n = 1; n <= N; n++) {
            int cnt = 0;

            for (int i = 0; i < 1002; i++) {
                for (int j = 0; j < 1002; j++) {
                    if(Arr[j][i] == n) {
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}