import java.io.*;
import java.util.*;

public class Main {

    static int arr[][], k, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] arr = new int[str1.length()][str2.length()];

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    arr[i][j]++;
                    if(i-1 >= 0 && j-1 >= 0)
                        arr[i][j] += arr[i-1][j-1]; // str1과 str2가 얼마나 겹치는지 숫자
                } else {
                    if(i == 0 && j == 0) {
                    } else if(i == 0) {
                        arr[i][j] = arr[i][j-1];
                    } else if(j == 0) {
                        arr[i][j] = arr[i-1][j];
                    } else {
                        arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
                    }
                }
            }
        }

        int ans = arr[str1.length()-1][str2.length()-1];



        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}