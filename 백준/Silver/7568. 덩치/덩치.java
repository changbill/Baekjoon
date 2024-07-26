import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N+1][2];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());   // 키
            arr[i][1] = Integer.parseInt(st.nextToken());   // 몸무게
        }

        for(int i = 1; i <= N; i++) {
            int rank = 1;
            for(int j = 1; j <= N; j++) {
                if(i == j) continue;
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }

            sb.append(rank + " ");
        }

        System.out.println(sb);
    }
}