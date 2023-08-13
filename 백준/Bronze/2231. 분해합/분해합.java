import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = i + "";
            int cons = i;

            for (int j = 0; j < str.length(); j++) {
                int num = str.charAt(j) - '0';
                cons += num;
            }
            if(cons == N) {
                System.out.println(i);
                break;
            }
            if(i==N-1) {
                System.out.println(0);
            }
        }
    }
}