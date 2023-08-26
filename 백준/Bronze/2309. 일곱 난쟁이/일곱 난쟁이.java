import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int idx = 0;

        List<Integer> list = new ArrayList<>();

        for(int t = 0; t<9; t++) {
            int tmp = Integer.parseInt(br.readLine());
            list.add(tmp);
            sum += tmp;
        }

        loop:
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {

                if(sum - list.get(i) - list.get(j) == 100) {
                    list.remove(j);
                    list.remove(i);
                    break loop;
                }

            }
        }

        Queue<Integer> q = new LinkedList<>();

        while(list.size()!=0) {
            int min = 100;
            for (int i = 0; i < list.size(); i++) {

                if(min>list.get(i)) {
                    min = list.get(i);
                    idx = i;
                }

            }
            list.remove(idx);
            q.offer(min);
        }

        for (int i = 0; i < 7; i++) {
            sb.append(q.poll()).append("\n");
        }

        System.out.println(sb);
    }
}