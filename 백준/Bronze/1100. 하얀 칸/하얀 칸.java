import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[][] Arr = new int[8][8];
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                Arr[i][j] = str.charAt(j);
            }
        } // 입력 완료

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i+j)%2 == 0 && Arr[i][j] == 'F') {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}