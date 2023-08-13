import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> list = new ArrayList<>();
        String str = br.readLine();
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j+i <= str.length(); j++) {
                String st = str.substring(j, j + i);
                list.add(st);
            }
        }
        Set<String> set = new HashSet<>(list);
        list = new ArrayList<>(set);

        System.out.println(list.size());
    }
}