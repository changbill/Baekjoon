import java.io.*;
import java.util.*;

public class Main {
    public static boolean binarySearch(int Arr[], int target, int start, int last) {
        if (start > last) return false;
        int mid = (start + last)/2;
        if (Arr[mid] == target) {
            return true;
        } else if (Arr[mid] < target) {
            return binarySearch(Arr, target, mid+1, last);
        } else {
            return binarySearch(Arr, target, start, mid-1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] Arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Arr);
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if (binarySearch(Arr, Integer.parseInt(st.nextToken()), 0, N-1)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            if(i==M-1) break;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}