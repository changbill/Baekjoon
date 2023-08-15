import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static boolean check(List<Character> list){
        String tmp = list.toString();
        Collections.reverse(list);
        if(tmp.equals(list.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean makeList(List<Character> list, String str, int startlen, int endlen, boolean ok) throws IOException{
        if (list.size() == 1) {
            return true;
        } else {
            if (ok == true) { // true일 때만 진행
                if (startlen < endlen) { // 시작점이 끝점보다 작을 때만 진행
                    list.clear();
                    for (int i = startlen; i < endlen; i++) {
                        list.add(str.charAt(i));
                    }
                    int mid = (startlen + endlen) / 2;
                    if (check(list)) {
                        makeList(list, str, 0, mid, ok);
                        if (!check(list)) {
                            return false;
                        }
                        makeList(list, str, mid + 1, str.length(), ok);
                        if (!check(list)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        List<Character> list = new ArrayList<>();
        boolean ok = true;
        if(makeList(list, str, 0, str.length(), ok)) {
            bw.write("AKARAKA");
        } else {
            bw.write("IPSELENTI");
        }

        bw.close();
    }
}