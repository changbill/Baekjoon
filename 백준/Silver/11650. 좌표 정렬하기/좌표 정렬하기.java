import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        boolean flag = true;
        int N = Integer.parseInt(br.readLine());
        int[][] NArr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            NArr[i][0] = Integer.parseInt(st.nextToken());
            NArr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(NArr, (e1, e2) -> {
            if(e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            sb.append(NArr[i][0]+" "+NArr[i][1]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}