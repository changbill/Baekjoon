import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int K = Integer.parseInt(st.nextToken()); // 한방에 배정할 수 있는 최대 인원수
        int[] Arr = new int[17]; // 카운팅 정렬

        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            Arr[Integer.parseInt(st.nextToken()+st.nextToken())]++;
        } // 입력 완

        int cnt = 0;
        for (int i = 1; i < 17; i++) {
            cnt += Arr[i]/2 + Arr[i]%2;
        }
        System.out.println(cnt);
    }
}