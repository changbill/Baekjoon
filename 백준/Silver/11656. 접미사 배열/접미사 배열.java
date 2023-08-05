
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언

        String S = br.readLine();
        List<String> Arr = new ArrayList<>();

        for (char i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < S.length(); j++) {
                if(S.charAt(j) == i) {
                    Arr.add(S.substring(j));
                }
            }
            if(Arr == null) continue;

            Collections.sort(Arr);
            for (int j = 0; j < Arr.size(); j++) {
                System.out.println(Arr.get(j));
            }
            Arr.clear();
       }
    }
}