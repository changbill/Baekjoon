import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // 백준
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] card = new int[N];
        int sum = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            card[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    sum = (card[i] + card[j] + card[k]);
                    if (sum <= M) {
                        if (answer < sum) {
                            answer = sum;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
