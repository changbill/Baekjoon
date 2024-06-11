import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] forwardArr = new int[N+1];
        int[] reverseArr = new int[N+1];
        int[] distanceArr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =1; i <= N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            reverseArr[tmp] = i; // tmp가 몇(i)번째에 있는지
            forwardArr[i] = tmp; // 몇(i)번째에 뭐(tmp)가 있는지
        }

        for(int i = 1; i <= N; i++) {
            int currentVal = forwardArr[i];
            int targetIndex = reverseArr[i];

            if(targetIndex != i) {
                int diff = Math.abs(targetIndex - i);
                distanceArr[currentVal] += diff;
                distanceArr[forwardArr[targetIndex]] += diff;

                // 배열 교환
                int temp = forwardArr[i];
                forwardArr[i] = forwardArr[targetIndex];
                forwardArr[targetIndex] = temp;

                // reverseArr 업데이트
                reverseArr[forwardArr[targetIndex]] = targetIndex;
                reverseArr[forwardArr[i]] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=N; i++) {
            sb.append(distanceArr[i] + " ");
        }

        System.out.println(sb.toString());
    }
}