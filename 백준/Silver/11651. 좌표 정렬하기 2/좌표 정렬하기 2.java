import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x,y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> arr = new PriorityQueue<>((o1, o2) -> {
            if(o1.y != o2.y) return o1.y - o2.y;
            return o1.x - o2.x;
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Node(x,y));
        }

        for (int i = 0; i < N; i++) {
            Node node = arr.poll();
            sb.append(node.x +" "+node.y+"\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}