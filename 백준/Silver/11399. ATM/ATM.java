import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 사람 숫자 받기
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;
        int sumSum = 0;
        for (int i = 0; i < N; i++) {
            sum += pq.poll();
            sumSum += sum;
        }

        System.out.println(sumSum);
    }
}