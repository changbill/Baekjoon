import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 1; i <= 10_000_000; i++) {
            sum += i;
            if(sum > X) {
                sum -= i;
                if(i % 2 == 0) {
                    int upper = 0;
                    int downer = i+1;
                    while(sum < X) {
                        sum++;
                        upper++;
                        downer--;
                    }
                    System.out.println(upper + "/" + downer);
                } else {
                    int upper = i+1;
                    int downer = 0;
                    while(sum < X) {
                        sum++;
                        upper--;
                        downer++;
                    }
                    System.out.println(upper + "/" + downer);
                }
                return;
            } else if(sum == X) {
                if(i % 2 == 0) {
                    int upper = i;
                    int downer = 1;
                    System.out.println(upper + "/" + downer);
                } else {
                    int upper = 1;
                    int downer = i;
                    System.out.println(upper + "/" + downer);
                }
                return;
            }

        }
    }
}
