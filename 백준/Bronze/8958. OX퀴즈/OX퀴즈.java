
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        int T = Integer.parseInt(br.readLine());
        String str = "";



        for (int i = 0; i < T; i++) {
            int sum = 0;
            int cnt = 0;
            str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'O') {
                    cnt++;
                } else {
                    cnt = 0;
                }
                sum += cnt;
            }
            System.out.println(sum);
        }

    }
}