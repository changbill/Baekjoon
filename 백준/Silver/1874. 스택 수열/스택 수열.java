import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int NArr[] = new int[N+1];
        for(int i = 1; i <= N; i++) {
            NArr[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int ansIdx = 1;
        int idx = 1;
        boolean ansArr[] = new boolean[2*N+1];
        // push할지 pop할지 오름차순 숫자
        for(int i = 1; i <= N; i++) {
            int temp = stack.isEmpty() ? 0 : stack.peekLast();
            while(NArr[i] > temp) {
                ansArr[ansIdx++] = true;   // true : +
                stack.add(idx++);
                temp = stack.peekLast();
            }

            if(NArr[i] == temp) {
                ansArr[ansIdx++] = false;   // false : -
                stack.pollLast();
            } else {
                System.out.println("NO");
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < ansArr.length; i++) {
            if(ansArr[i]) {
                sb.append("+\n");
            } else{
                sb.append("-\n");
            }
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }
}