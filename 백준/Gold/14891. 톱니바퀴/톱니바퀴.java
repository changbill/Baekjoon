
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int gear[][], tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        gear = new int[5][9];
        for (int t = 1; t <= 4; t++) {
            st= new StringTokenizer(br.readLine(),"01",true);
            for (int i = 1; i <= 8; i++) {
                gear[t][i] = Integer.parseInt(st.nextToken());  // row에는 톱니바퀴 번호, col엔 톱니 번호
            }
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int rot = Integer.parseInt(st.nextToken());

            mainfunc(num, rot);
        }

        int ans = 0;
        for (int i = 1; i <= 4; i++) {
            if(gear[i][1] == 1) { // i==1일때 1
                ans += (1<<i)/2;
            }
        }

        bw.write(Integer.toString(ans));
        bw.close();
        br.close();
    }


    public static void mainfunc(int num, int rot) {
        leftfunc(num - 1, -rot);
        rightfunc(num + 1, -rot);
        turn(num, rot);
    }

    public static void leftfunc(int num, int rot) {
        if (num < 1) return;
        if (gear[num][3] == gear[num + 1][7]) return;
        leftfunc(num - 1, -rot);
        turn(num, rot);
    }

    public static void rightfunc(int num, int rot) {
        if (num > 4) return;
        if (gear[num][7] == gear[num -1][3]) return;
        rightfunc(num +1, -rot);
        turn(num, rot);
    }

    public static void turn(int num, int rot) {
        if(rot == 1) {                          // 시계방향으로 한칸씩 돌리기
            tmp = gear[num][8];
            for (int i = 8; i >= 2; i--) {
                gear[num][i] = gear[num][i-1];
            }
            gear[num][1] = tmp;
        } else {                                // 반시계방향으로 한칸씩 돌리기
            tmp = gear[num][1];
            for (int i = 1; i <= 7; i++) {
                gear[num][i] = gear[num][i+1];
            }
            gear[num][8] = tmp;
        }
    }
}
