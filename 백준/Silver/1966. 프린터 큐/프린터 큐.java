
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt = 0;
            Queue <int[]> queue = new LinkedList<>(); // 자료구조 안에 배열 넣기 가능

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                // {초기 위치, 중요도}
                queue.offer(new int[] {i, Integer.parseInt(st.nextToken())});
            } // 꼭 Map을 통해서만 키, value를 저장할 필요가 없네

            while(true) {
                int[] front = queue.poll(); // 맨 앞 요소 poll
                boolean flag = true; // 인쇄할 것인지 true false

                for (int q[] : queue) { // queue에 있는 배열 빼내기
                    if(front[1] < q[1]) { // 인덱스 1에는 우선순위가 있으므로 poll한 요소보다 우선순위가 높은 것이 있다면
                        flag = false; // 인쇄 안함
                        break;
                    }
                }

                if (flag) { // 인쇄 할 시
                    cnt++; // 인쇄 카운트
                    if (front[0] == M) break; // M 번째 인덱스 인쇄할때 반복문 break
                } else { // 인쇄 안할 시 poll 했던 요소 맨 뒤에 offer
                    queue.offer(front);
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}