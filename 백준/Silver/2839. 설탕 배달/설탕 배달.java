import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        switch(N%5) {
            case 0:
                System.out.println(N/5);
                break;
            case 1: // N = 5*x + 6
                if(N>=6) {
                    System.out.println(N/5+1);
                } else {
                    System.out.println(-1);
                }
                break;
            case 2: // 5*x + 12
                if(N>=12) {
                    System.out.println(N/5+2);
                } else {
                    System.out.println(-1);
                }
                break;
            case 3: // N = 5*x + 3
                System.out.println(N/5+1);
                break;
            case 4: // N = 5*x + 3*8 = 5*x + 24
                if(N>=9) {
                    System.out.println(N/5+2);
                } else {
                    System.out.println(-1);
                }
                break;
        }
    }
}