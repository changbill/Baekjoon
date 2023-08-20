
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int k;
    static boolean [] flag;
    static int[] s;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while(true) {
            String str = br.readLine();
            if(str.equals("0")) break;
            String[] strings = str.split(" "); // split으로 나뉜것 배열로 한번에 받기
            k = Integer.parseInt(strings[0]); // 인덱스 1부터 k까지
            s = new int[k];
            flag = new boolean[k];

            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(strings[i+1]);
            }

            dfs(0,0);
            System.out.println();
        }
    }

    public static void dfs(int depth, int start) {
        if(depth == 6) {
            for (int i = 0; i < k; i++) {
                if(flag[i]) {
                    System.out.print(s[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = start; i < k; i++) {
            flag[i] = true;
            dfs(depth+1, i+1);
            flag[i] = false;
        }
    }
}