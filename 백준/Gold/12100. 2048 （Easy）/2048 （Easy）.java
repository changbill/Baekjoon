import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int NArr[][];        // 2048 필드
    static int ans = Integer.MIN_VALUE;   // 정답
    static int N;        // 필드 크기

    public static void play(int cnt) {
        if(cnt == 5) {
            findMax();
            return;
        }
        int copy[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = NArr[i].clone();
        }

        for (int i = 0; i < 4; i++) {
            move(i);
            play(cnt+1);
            for (int j = 0; j < N; j++) {
                NArr[j] = copy[j].clone();
            }
        }
    }

    public static void move(int dir) {
        switch(dir) {
            //위로 몰기
            case 0:
                for(int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < N; j++) {
                        if(NArr[j][i] != 0) {
                            if(block == NArr[j][i]) {
                                NArr[index - 1][i] = block * 2;
                                block = 0;
                                NArr[j][i] = 0;
                            }
                            else {
                                block = NArr[j][i];
                                NArr[j][i] = 0;
                                NArr[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            //왼쪽으로 몰기
            case 1:
                for(int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for(int j = N - 1; j >= 0; j--) {
                        if(NArr[j][i] != 0) {
                            if(block == NArr[j][i]) {
                                NArr[index + 1][i] = block * 2;
                                block = 0;
                                NArr[j][i] = 0;
                            }
                            else {
                                block = NArr[j][i];
                                NArr[j][i] = 0;
                                NArr[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            //왼쪽으로 몰기
            case 2:
                for(int i = 0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j < N; j++) {
                        if(NArr[i][j] != 0) {
                            if(block == NArr[i][j]) {
                                NArr[i][index - 1] = block * 2;
                                block = 0;
                                NArr[i][j] = 0;
                            }
                            else {
                                block = NArr[i][j];
                                NArr[i][j] = 0;
                                NArr[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            //오른쪽으로 몰기
            case 3:
                for(int i = 0; i < N; i++) {
                    int index = N - 1;
                    int block = 0;
                    for(int j = N - 1; j >= 0; j--) {
                        if(NArr[i][j] != 0) {
                            if(block == NArr[i][j]) {
                                NArr[i][index + 1] = block * 2;
                                block = 0;
                                NArr[i][j] = 0;
                            }
                            else {
                                block = NArr[i][j];
                                NArr[i][j] = 0;
                                NArr[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }

    public static void findMax() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, NArr[i][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // 컴퓨터 수(정점)
        NArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                NArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        play(0);
        bw.write(Integer.toString(ans));
        bw.close();
        br.close();
    }
}