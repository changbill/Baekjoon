import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> numList = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while(N != 0) {
            int i = N % B;  // 나머지(X의 자리 수)
            int j = N / B;  // 몫

            N = j;
            numList.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = numList.size() - 1; i >= 0; i--) {
            int digit = numList.get(i);
            if(digit >= 10) {
                sb.append((char) (digit - 10 + 'A'));
            } else {
                sb.append(digit);
            }
        }

        System.out.println(sb.toString());
    }
}
