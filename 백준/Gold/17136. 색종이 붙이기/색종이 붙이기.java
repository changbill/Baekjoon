import java.io.*;
import java.util.*;

public class Main {

    static boolean map[][];
    static int paperArr[];
    static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new boolean[11][11];
        for (int i = 1; i <= 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        paperArr = new int[6];
        for (int i = 1; i <= 5; i++) {
            paperArr[i] = 5;
        }

        dfs(1,1,0);

        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }

    private static void dfs(int x, int y, int cnt) {
        if(x > 10) {
            min = Math.min(min, cnt);
            return;  // 끝에 도달하면 종료
        }

        if(min <= cnt) return;  // 최소 개수보다 같거나 더 많은 색종이를 붙이고 있다면 검색 필요 X

        if(map[x][y]) {     // 색종이 붙여야하는 타일이라면
            for(int i = 5; i >= 1; i--) {
                if(x + i <= 11 && y + i <= 11 && paperArr[i] > 0 && attach(x, y, i)) {       // i*i 색종이 붙일 수 있으면
                    paperArr[i]--;
                    if(y+1 > 10) {
                        dfs(x+1, 1, cnt+1);
                    } else {
                        dfs(x, y+1, cnt+1);
                    }
                    paperArr[i]++;
                    detach(x, y, i);
                }
            }
        } else {
            if(y+1 > 10) {
                dfs(x+1, 1, cnt);
            } else {
                dfs(x, y+1, cnt);
            }
        }
    }

    // TODO: x+i, y+j 배열 내로 돌게 하기
    private static void detach(int x, int y, int num) {
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                map[x+i][y+j] = true;
            }
        }
    }

    private static boolean attach(int x, int y, int num) {
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                if(!map[x+i][y+j]) return false;
            }
        }

        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                map[x+i][y+j] = false;
            }
        }
        return true;
    }
}
