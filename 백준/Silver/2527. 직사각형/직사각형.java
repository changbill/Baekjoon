import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 4; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 첫번째 직사각형 좌표
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());

            // 두번째 직사각형 좌표
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            if(p1<x2 || q1<y2 || p2<x1 || q2<y1) {
                // 공통부분이 없음
                sb.append('d');
            } else if ((x2 == p1 && y2 == q1) || (x1 == p2 && q1 == y2) || (x1 == p2 && y1 == q2) || (x2 == p1 && y1 == q2)) {
                // 점
                sb.append('c');
            } else if (x2 == p1 || y2 == q1 || y1 == q2 || x1 == p2) {
                // 선분
                sb.append('b');
            } else {
                // 직사각형
                sb.append('a');
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}