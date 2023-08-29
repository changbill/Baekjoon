import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);
            sb.append(list.get(7));
            sb.append("\n");
        }


        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}