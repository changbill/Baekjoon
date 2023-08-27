import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < 10; t++) {
            sb.append("#" + (t + 1) + "\n");

            int N = Integer.parseInt(br.readLine());
            int[][] NArr = new int[N][N];
            int[][] oneArr = new int[N][N];
            int[][] twoArr = new int[N][N];
            int[][] threeArr = new int[N][N];
            for (int i = 0; i < N; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    NArr[i][j] = Integer.parseInt(st.nextToken());
                }

            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    oneArr[i][j] = NArr[N-1-j][i];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    twoArr[i][j] = oneArr[N-1-j][i];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    threeArr[i][j] = twoArr[N-1-j][i];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(oneArr[i][j]);
                }

                sb.append(" ");

                for (int j = 0; j < N; j++) {
                    sb.append(twoArr[i][j]);
                }

                sb.append(" ");

                for (int j = 0; j < N; j++) {
                    sb.append(threeArr[i][j]);
                }

                sb.append("\n");
            }
            
        }
        System.out.println(sb);
    }
}