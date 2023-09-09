import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

//        List<Integer> list = new ArrayList<>();

        sb.append("<");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N];

        int idx = 0;
        int cnt = 0;
        int num = 0;
        while(true) {
            if(idx == N) {
                idx = 0;
            }
            if(arr[idx]) { // 이미 왔던 곳이라면 지나가기
                idx++;
            } else { // 안 와봤다면
                cnt++; // 카운트

                if (cnt == K) { // K만큼 카운트했다면
                    cnt = 0; // 카운트 0으로 초기화
                    arr[idx] = true;
                    sb.append(idx+1);
                    num++;
                    if(num == N) break;
                    sb.append(", ");
                }
                idx++;
            }

        }
        sb.append(">");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}