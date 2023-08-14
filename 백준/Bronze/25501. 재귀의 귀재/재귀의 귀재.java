import java.io.*;
import java.util.*;

public class Main {

    public static String recursion(String s, int l, int r, int cnt) {
        if(l >= r) return (1+" "+cnt);
        else if (s.charAt(l) != s.charAt(r)) return (0+" "+cnt);
        else cnt++; return recursion(s, l+1, r-1, cnt);
    }

    public static String isPalindrome(String s) {
        int cnt =1;
        return recursion(s, 0, s.length()-1, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            System.out.println(isPalindrome(str));
        }
    }
}