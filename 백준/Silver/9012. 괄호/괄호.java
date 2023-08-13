import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();



        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int cnt = 0;
            for (int j = 0; j < str.length(); j++) {
                if (j==0 && str.charAt(j)!='(') {
                    sb.append("NO");
                    break;
                }
                if(str.charAt(j) == '(') {
                    cnt++;
                }
                if(str.charAt(j) == ')') {
                    cnt--;
                    if(cnt < 0) {
                        sb.append("NO");
                        break;
                    }
                }
                if(j == str.length()-1 && cnt == 0 && str.charAt(j) == ')') {
                    sb.append("YES");
                } else if (j == str.length()-1) {
                    sb.append("NO");
                }
            }
            if(i == N-1) break;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}