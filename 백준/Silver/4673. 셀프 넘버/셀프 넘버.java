import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 1; i <= 10000; i++) {
            int tmp = i;
            int sum = tmp;  // tmp : 생성자, sum
            while(tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if(!map.containsKey(sum)) {
                map.put(sum,1);
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if(!map.containsKey(i)) {
                sb.append(i+"\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}