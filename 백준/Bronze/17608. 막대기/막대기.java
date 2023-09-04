import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> s = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            s.push(Integer.parseInt(br.readLine()));
        }

        int max = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int tmp = s.pop();
            if(max < tmp) {
                max = tmp;
                cnt++;
            }
        }

        bw.write(Integer.toString(cnt));
        bw.close();
        br.close();
    }
}