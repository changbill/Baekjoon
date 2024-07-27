import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3; i++) {
            String str = br.readLine();
            switch(str) {
                case "FizzBuzz":
                    break;
                case "Fizz":
                    break;
                case "Buzz":
                    break;
                default:
                    int x = Integer.parseInt(str);
                    int nextNum = x + (3-i);
                    if(nextNum % 15 == 0) {
                        System.out.println("FizzBuzz");
                    } else if(nextNum % 5 == 0) {
                        System.out.println("Buzz");
                    } else if(nextNum % 3 == 0) {
                        System.out.println("Fizz");
                    } else {
                        System.out.println(nextNum);
                    }
                    return;
            }
        }

    }
}