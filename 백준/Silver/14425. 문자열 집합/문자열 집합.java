import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        HashMap<String,Boolean> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int n = 0; n < N; n++) {
            map.put(br.readLine(),false);
        }

        int num = 0;
        for (int m = 0; m < M; m++) {
            if(map.containsKey(br.readLine())) {
                num++;
            };
        }

        bw.write(Integer.toString(num));
        bw.close();
        br.close();
    }
}