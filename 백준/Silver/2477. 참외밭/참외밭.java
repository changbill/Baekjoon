import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        List<int[]> list = new ArrayList<>();

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }

        while(list.get(0)[0] != list.get(2)[0] || list.get(1)[0] != list.get(3)[0]) {
            list.add(list.remove(0));
        }

        int ans = K*(list.get(4)[1]*list.get(5)[1] - list.get(1)[1]*list.get(2)[1]);

        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }
}