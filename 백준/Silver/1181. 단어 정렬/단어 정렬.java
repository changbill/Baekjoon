import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()-o2.length() != 0) {
                    return o1.length()-o2.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        Iterator<String> iter = set.iterator();

        while(iter.hasNext()) {
            pq.offer(iter.next());
        }

        while(!pq.isEmpty()) {
            sb.append(pq.poll()+"\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}