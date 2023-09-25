
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int aarr[] = {1,2,3,4,5,6,7,8};
        boolean aflag = true;
        int darr[] = {8,7,6,5,4,3,2,1};
        boolean dflag = true;
        for (int i = 0; i < 8; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(aflag) {
                if(aarr[i] != tmp) aflag = false;
            }
            if(dflag) {
                if(darr[i] != tmp) dflag = false;
            }
        }

        if(aflag) {
            sb.append("ascending");
        } else if(dflag) {
            sb.append("descending");
        } else {
            sb.append("mixed");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}