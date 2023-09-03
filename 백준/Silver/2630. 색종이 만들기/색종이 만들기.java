import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] NArr;
    static int N;
    static int blue;
    static int white;

    public static void divide(int row, int col, int size) {
        for (int i = row; i < row+size; i++) {
            for (int j = col; j < col+size; j++) {
                if(NArr[row][col] != NArr[i][j]) {
                    divide(row,col,size/2);
                    divide(row+size/2, col,size/2);
                    divide(row,col+size/2,size/2);
                    divide(row+size/2,col+size/2,size/2);
                    return;
                }
            }
        }

        if(NArr[row][col]) {
            blue++;
        } else {
            white++;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        NArr = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                if(1 == Integer.parseInt(st.nextToken())) {
                    NArr[i][j] = true;
                }
            }
        }

        divide(0,0,N);
        bw.write(Integer.toString(white)+"\n"+Integer.toString(blue));
        bw.close();
        br.close();
    }
}