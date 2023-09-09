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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        Stack<Integer>[] arr = new Stack[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Stack<>();
        }

        int cnt = 0; // 움직인 횟수
        loop:
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int strNum = Integer.parseInt(st.nextToken());
            int frets = Integer.parseInt(st.nextToken());
            Stack<Integer> s = arr[strNum-1];

            if(s.isEmpty()) { // 스택이 비어있다면
                s.push(frets); // 해당 프렛 스택에 넣기(누르기)
                cnt++; // 손가락 움직임
            } else { // 스택에 값이 있다면
                while(s.peek() > frets) { // 해당 프렛이 스택 맨 위의 원소보다 작을때
                    s.pop(); // 스택에서 pop(손가락을 땐다)
                    cnt++; // 손가락 움직임
                    if(s.isEmpty()) {
                        s.push(frets);
                        cnt++;
                        continue loop;
                    }
                }
                // 해당 프렛이 스택 맨위의 원소보다 큰 경우
                if(s.peek() < frets) {
                    s.push(frets);
                    cnt++;
                }
            }
        }

        bw.write(Integer.toString(cnt));
        bw.close();
        br.close();
    }
}