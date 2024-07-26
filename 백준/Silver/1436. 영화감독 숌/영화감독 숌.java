import java.io.*;
import java.util.*;

public class Main {
    static int MAX_VALUE = 10_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long arr[] = new long[MAX_VALUE+1];
        int idx = 1;
        long val = 666;
        while(idx <= MAX_VALUE) {
            if(Long.toString(val).contains("666")) {
                arr[idx++] = val;
            }
            val++;
        }

        int N = Integer.parseInt(br.readLine());
        System.out.println(arr[N]);
    }
}