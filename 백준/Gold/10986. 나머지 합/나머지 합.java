import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int NArr[] = new int[N+1];
        long MArr[] = new long[M+1];
        long result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            NArr[i] = (NArr[i-1] + Integer.parseInt(st.nextToken())) % M;
            if(NArr[i] == 0) {
                result++;
            }
            MArr[NArr[i]]++;
        }

        for(int i = 0; i < M; i++) {
            result += MArr[i] * (MArr[i]-1) / 2;
        }

        System.out.println(result);
    }
}