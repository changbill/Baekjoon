import java.io.*;
import java.util.*;

public class Main {

    static int N, L;
    static int map[][];
    static boolean runway[];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }   // 입력완

        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(horizontal(i)) cnt++;
            if(vertical(i)) cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean vertical(int j) {
        runway = new boolean[N + 1];

        for(int i = 1; i < N; i++) {
            int diff = map[i][j] - map[i+1][j];
            if(diff > 1 || diff < -1) return false;

            if(diff == 1) {
                if(i + L > N) return false;

                for(int k = 1; k <= L; k++) {
                    if(map[i + 1][j] != map[i+k][j] || runway[i+k]) return false;
                    runway[i+k] = true;
                }
            }

            if(diff == -1) {
                if(i - L + 1 < 0) return false;
                for(int k = 1; k <= L; k++) {
                    if(map[i][j] != map[i-k+1][j] || runway[i-k+1]) return false;
                    runway[i-k+1] = true;
                }
            }
        }

        return true;
    }

    private static boolean horizontal(int i) {
        runway = new boolean[N + 1];

        for(int j = 1; j < N; j++) {
            int diff = map[i][j] - map[i][j+1];
            if(diff > 1 || diff < -1) return false;

            if(diff == 1) {
                if(j + L > N) return false;

                for(int k = 1; k <= L; k++) {
                    if(map[i][j + 1] != map[i][j+k] || runway[j+k]) return false;
                    runway[j+k] = true;
                }
            }

            if(diff == -1) {
                if(j - L + 1 < 0) return false;
                for(int k = 1; k <= L; k++) {
                    if(map[i][j] != map[i][j-k+1] || runway[j-k+1]) return false;
                    runway[j-k+1] = true;
                }
            }
        }

        return true;
    }
}
