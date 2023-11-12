import java.io.*;
import java.util.*;

public class Main {

    static char[] word;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            word = br.readLine().toCharArray();
            int ri = word.length-1;
            int le = 0;

            // 왼쪽 포인터와 오른쪽 포인터 비교했을때 같고, 왼쪽 인덱스가 더 작다면
            while(word[le] == word[ri] && le < ri) {
                // 포인터를 이동한다
                le++;
                ri--;
            }

            if(le >= ri) {
                sb.append(0+"\n");
                continue;
            }

            int leTmp = le;
            int riTmp = ri;

            leTmp++;        // 왼쪽 포인터를 한칸 이동해본다

            // 왼쪽 포인터 이동한 경우 회문 여부 확인
            if(twoPoint(leTmp, riTmp)) {
                sb.append(1+"\n");
                continue;
            }

            leTmp--;        // 되돌리기
            riTmp--;        // 오른쪽 포인터 한칸 이동해본다

            // 오른쪽 포인터 이동한 경우 회문 여부 확인
            if(twoPoint(leTmp, riTmp)) {
                sb.append(1+"\n");
                continue;
            }

            sb.append(2+"\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static boolean twoPoint(int le, int ri) {
        // 왼쪽 포인터와 오른쪽 포인터 비교했을때 같고, 왼쪽 인덱스가 더 작다면
        while(word[le] == word[ri] && le < ri) {
            // 포인터를 이동한다
            le++;
            ri--;
        }

        if(le >= ri) {
            return true;        // 회문 확인 true 반환
        }
        return false;           // 회문 불가 false 반환
    }
}