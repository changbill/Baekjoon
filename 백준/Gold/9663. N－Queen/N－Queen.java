import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] Arr;
    static int cnt = 0;

    public static void nQueen(int depth) {
        if(depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            Arr[depth] = i;
            if(isSafe(depth)) {
                nQueen(depth+1);
            }
        }
    }

    public static boolean isSafe(int col) {
        for (int i = 0; i < col; i++) {
            if(Arr[i] == Arr[col]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(Arr[col] - Arr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Arr = new int[N];

        nQueen(0);
        bw.write(Integer.toString(cnt));
        bw.close();
    }
}