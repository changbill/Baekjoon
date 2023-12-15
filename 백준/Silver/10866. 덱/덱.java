import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int X = 0;
        int tmp = 0;
        String str;
        LinkedList<Integer> deque = new LinkedList<>();

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            if(st.hasMoreTokens()) {
                X = Integer.parseInt(st.nextToken());
            }
            switch (str) {
                case "push_front":
                    deque.addFirst(X);
                    break;
                case "push_back":
                    deque.addLast(X);
                    break;
                case "pop_front":
                    try {
                        tmp = deque.pollFirst();
                        sb.append(tmp+"\n");
                    } catch (NullPointerException e) {
                        sb.append(-1+"\n");
                    }
                    break;
                case "pop_back":
                    try {
                        tmp = deque.pollLast();
                        sb.append(tmp+"\n");
                    } catch (NullPointerException e) {
                        sb.append(-1+"\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()+"\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) {
                        sb.append(1+"\n");
                    } else {
                        sb.append(0+"\n");
                    }
                    break;
                case "front":
                    try {
                        tmp = deque.peekFirst();
                        sb.append(tmp+"\n");
                    } catch (NullPointerException e) {
                        sb.append(-1+"\n");
                    }
                    break;
                case "back":
                    try {
                        tmp = deque.peekLast();
                        sb.append(tmp+"\n");
                    } catch (NullPointerException e) {
                        sb.append(-1+"\n");
                    }
                    break;
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}