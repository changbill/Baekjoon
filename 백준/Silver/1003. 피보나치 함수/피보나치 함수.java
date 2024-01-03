import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static class Node {
        int one, zero;
        Node(int one, int zero) {
            this.one = one;
            this.zero = zero;
        }
    }

    static Node dp[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            dp = new Node[N+1];
            dp[0] = new Node(0,1);
            if(N != 0) {
                dp[1] = new Node(1,0);
            }
            Node node = fibonacci(N);
            System.out.println(node.zero+" "+node.one);
        }

    }

    public static Node fibonacci(int N) {
        if(dp[N] != null) {
            return dp[N];
        } else {
            Node node1 = fibonacci(N-1);
            Node node2 = fibonacci(N-2);
            int one = node1.one + node2.one;
            int zero = node1.zero + node2.zero;
            return dp[N] = new Node(one, zero);
        }
    }
}