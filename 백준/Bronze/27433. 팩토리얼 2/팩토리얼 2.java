import java.io.*;
import java.util.*;

public class Main {

    public static long factorial(long N, long mul) {
        if(N == 1) {
            return mul;
        }
        return factorial(N-1, (N-1)*mul);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        if(N == 0) {
            System.out.println(1);
        } else {
            System.out.println(factorial(N, N));
        }
    }
}