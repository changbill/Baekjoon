import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean[][] Arr = new boolean[101][101];
        int cnt = 0;

        int deli[] = {0, -1, 0, 1};
        int delj[] = {-1, 0, 1, 0};

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    Arr[Y + i][X + j] = true;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (Arr[i][j]) {
                    for (int k = 0; k < 4; k++) {
                        if (!Arr[i + deli[k]][j + delj[k]]) {
                            cnt++;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}