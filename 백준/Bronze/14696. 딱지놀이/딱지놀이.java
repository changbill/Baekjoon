import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();



        int N = Integer.parseInt(br.readLine());
        for (int n = 1; n <= N; n++) {
            int[] AArr = new int[5]; // 4,3,2,1 카운트 정렬
            int[] BArr = new int[5];

            // A 친구 딱지 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int i = 0; i < a; i++) {
                AArr[Integer.parseInt(st.nextToken())]++;
            }

            // B 친구 딱지 입력
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for (int i = 0; i < b; i++) {
                BArr[Integer.parseInt(st.nextToken())]++;
            }

            for (int i = 4; i > 0; i--) {
                if(AArr[i] > BArr[i]) {
                    sb.append("A");
                    break;
                } else if (AArr[i] < BArr[i]) {
                    sb.append("B");
                    break;
                }

                if(i==1 && AArr[i] == BArr[i]) {
                    sb.append("D");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}