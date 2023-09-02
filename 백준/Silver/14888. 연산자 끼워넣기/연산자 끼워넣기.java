import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

    static int max = -1000000000;
    static int min = 1000000000;
    static int[] NArr;
    static int[] cal = new int[4];
    static int N;
    public static void dfs(int num, int idx) {
        if(idx == N) {
            if(max < num) {
                max = num;
            }
            if(min > num) {
                min = num;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (cal[i] > 0) {
                cal[i]--;
                switch(i) {
                    case 0 : dfs(num + NArr[idx], idx + 1); break;
                    case 1 : dfs(num - NArr[idx], idx + 1); break;
                    case 2 : dfs(num * NArr[idx], idx + 1); break;
                    case 3 : dfs(num / NArr[idx], idx + 1); break;
                }
                cal[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        NArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            NArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        dfs(NArr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }
}