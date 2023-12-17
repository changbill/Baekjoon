import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static double N,M,V,max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Math.pow(Integer.parseInt(st.nextToken()), 2);
            M = Math.pow(Integer.parseInt(st.nextToken()), 2);
            V = Math.pow(Integer.parseInt(st.nextToken()), 2);

            if(N == 0 && M == 0 && V == 0) {
                break;
            } else {
                max = Math.max(Math.max(N,M), V);
                if(max * 2 == N + M + V) {
                    sb.append("right"+"\n");
                } else {
                    sb.append("wrong"+"\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}