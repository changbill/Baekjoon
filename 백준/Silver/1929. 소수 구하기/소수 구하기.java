import java.io.*;
import java.util.*;

public class Main {

    static int MAX_VALUE = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        boolean isCompositeNum[] = new boolean[MAX_VALUE+1];
        isCompositeNum[1] = true;
        for(int i = 2; i <= MAX_VALUE; i++) {
            if(isCompositeNum[i]) continue;
            int idx = 2;
            while(i * idx <= MAX_VALUE) {
                if(!isCompositeNum[i * idx]) isCompositeNum[i * idx] = true;
                idx++;
            }
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        while(M <= N) {
            if(!isCompositeNum[M]) sb.append(M+"\n");
            M++;
        }

        System.out.println(sb);
    }
}