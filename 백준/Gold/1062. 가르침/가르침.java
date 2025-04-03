import java.io.*;
import java.util.*;

public class Main {

    static int N, K, max;
    static int wordArr[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 단어의 개수
        K = Integer.parseInt(st.nextToken());   // 가르칠 수 있는 글자 개수

        wordArr = new int[N+1];
        for(int n = 1; n <= N; n++) {
            char[] charArray = br.readLine().toCharArray();
            for(int i = 0; i < charArray.length; i++) {
                int alphaIdx = charArray[i] - 'a';  // 0~25
                wordArr[n] |= (1 << alphaIdx);
            }
        }

        int teachedAlpha = 0;
        teachedAlpha |= (1<<('a'-'a'));
        teachedAlpha |= (1<<('n'-'a'));
        teachedAlpha |= (1<<('t'-'a'));
        teachedAlpha |= (1<<('i'-'a'));
        teachedAlpha |= (1<<('c'-'a'));

        max = 0;
        if(K < 5) {
            System.out.println(max);
        } else {
            dfs(0,0, teachedAlpha);

            System.out.println(max);
        }



    }

    private static void dfs(int idx, int cnt, int teachedAlpha) {
        if(cnt + 5 >= K) {
            countWord(teachedAlpha);
            return;
        }

        for(int i = idx; i < 26; i++) {
            if((teachedAlpha & (1<<i)) != (1<<i)) { // 글자를 포함하지 않는다면
                teachedAlpha |= (1<<i);
                dfs(i + 1, cnt + 1, teachedAlpha);
                teachedAlpha -= (1<<i);
            }
        }
    }

    private static void countWord(int teachedAlpha) {
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if((wordArr[i] & teachedAlpha) == wordArr[i]) cnt++;
        }

        max = Math.max(max, cnt);
    }
}