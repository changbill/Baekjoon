
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int fin = Integer.parseInt(st.nextToken());
        int[] Arr = new int[1000];
        int idx = 0;
        int sum = 0;

        loop:
        for (int i = 1; i>0; i++) {
            for (int j = 0; j < i; j++) {
                Arr[idx++] = i;
                if (Arr[999] != 0) break loop;
            }
        }

        for (int i = start-1; i < fin; i++) {
            sum += Arr[i];
        }

        System.out.println(sum);


    }
}