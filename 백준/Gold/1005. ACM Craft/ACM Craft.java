import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        List<Node> copyOfPrev;
        List<Node> prev;
        List<Node> next;
        int time;
        int cur;

        Node(int time, int cur) {
            this.time = time;
            this.cur = cur;
            prev = new ArrayList<>();
            next = new ArrayList<>();
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 건물 개수
            int K = Integer.parseInt(st.nextToken());   // 건설순서 규칙 개수
            Node KArr[] = new Node[N+1];                // 건물 건설순서 규칙 배열

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                KArr[j] = new Node(Integer.parseInt(st.nextToken()), j);
            }                                           // 건설 시간 입력 완료

            for (int j = 1; j <= K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                KArr[X].next.add(KArr[Y]);  // X가 지어진 후 지을 수 있는 건물은 Y다.
                KArr[Y].prev.add(KArr[X]);  // Y 건물을 세우려면 X가 먼저 지어져야 한다.
            }                                           // 건설순서 규칙 배열 입력 완료

            int target = Integer.parseInt(br.readLine());
            Queue<Node> q = new LinkedList<>();
            int dp[] = new int[N+1];

            for(int j = 1; j <= N; j++) {
                KArr[j].copyOfPrev = new ArrayList<>(KArr[j].prev);
                if(KArr[j].prev.size() == 0) {
                    q.add(KArr[j]);
                }
            }

            while(!q.isEmpty()) {
                Node cur = q.poll();
                int asInt = cur.prev.stream()
                        .mapToInt(node -> dp[node.cur])
                        .max()
                        .orElse(0);   // 이전 node 전부 완성하는데 걸리는 시간

                dp[cur.cur] = asInt + cur.time;
                if(cur.cur == target) {
                    System.out.println(dp[cur.cur]);
                    break;
                }

                cur.next.forEach(node -> {
                    node.copyOfPrev.remove(cur);
                    if(node.copyOfPrev.size() == 0) {
                        q.add(node);
                    }
                });
            }
        }
    }
}