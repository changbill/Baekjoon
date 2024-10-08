import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void hanoi(int N, int start, int mid, int end) {
        if(N == 1) {
            sb.append(start + " " + end + "\n");
            return;
        }

        hanoi(N-1, start, end, mid);
        sb.append(start + " " + end + "\n");
        hanoi(N-1, mid, start, end);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sb.append((int) (Math.pow(2, N) - 1)).append("\n");

        hanoi(N,1,2,3);
        System.out.println(sb);
    }
}