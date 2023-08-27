import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            sb.append("#" + (t + 1) + " ");

            String str = br.readLine();
            String strNone = "CEFGHIJKLMNSTUVWXYZ";
            String strOne = "ADOPQR";

            for (int i = 0; i < strNone.length(); i++) {
                str = str.replace(strNone.charAt(i), 'x');
            }

            for (int i = 0; i < strOne.length(); i++) {
                str = str.replace(strOne.charAt(i), 'o');
            }

            StringTokenizer st = new StringTokenizer(str);
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            if (str1.equals(str2)) {
                sb.append("SAME");
            } else {
                sb.append("DIFF");
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}