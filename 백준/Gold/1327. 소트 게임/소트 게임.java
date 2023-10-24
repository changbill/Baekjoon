
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static class Node{
        String str;
        int cnt;

        public Node(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }

    static String copyStr, ansStr;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 순열의 크기
        K = Integer.parseInt(st.nextToken()); // 몇번째 수부터 뒤집을까

        char arr[];
        arr = br.readLine().replace(" ","").toCharArray();

        copyStr = new String(arr);
        Arrays.sort(arr);
        ansStr = new String(arr);

        bw.write(Integer.toString(bfs()));
        bw.close();
        br.close();
    }

    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(new Node(copyStr,0));
        set.add(copyStr);

        while(!q.isEmpty()) {
            Node tmp = q.poll();
            String str = tmp.str;
            int cnt = tmp.cnt;

            if(str.equals(ansStr)) return cnt;

            for (int i = 0; i <= N-K; i++) {
                String tStr = reverseStr(str, i, i+K);
                if(!set.contains(tStr)) {
                    set.add(tStr);
                    q.add(new Node(tStr,cnt+1));
                }
            }
        }
        return -1;
    }

    public static String reverseStr(String str, int i, int j) {
        StringBuilder sb = new StringBuilder();
        StringBuilder rb = new StringBuilder();
        sb.append(str.substring(0,i));
        rb.append(str.substring(i,j));
        sb.append(rb.reverse());
        sb.append(str.substring(j,str.length()));
        return sb.toString();
    }
}
