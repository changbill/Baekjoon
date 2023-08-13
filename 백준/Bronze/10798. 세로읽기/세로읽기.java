import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] word = new String[5];
        int max = 0;
        int[] Arr = new int[5];

        for (int i = 0; i < 5; i++) {
            word[i] = sc.next(); // 5줄의 문자열 입력
        }


        for (int i = 0; i < 5; i++) {
            Arr[i] = word[i].length();
            if (Arr[i] >= max) {
                max = Arr[i]; // 문자열 최대 길이 구하기
            }
        }

        // for문으로 최대 길이 까지 substring 돌리기
        for (int i = 0; i < max; i++) { // max == 6
            for (int j = 0; j < 5; j++) {
                if (i+1 /*6*/<= Arr[j]/*4*/) {
                    System.out.print(word[j].substring(i,i+1));// 문자열 최대 길이보다 구하려는 문자가 크다면 continue
                }
            }
        }
    }
}