import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        /**
         * ((A^2)^2)^2...)이런 식으로 제곱으로 나타내면 제곱 수는 1 2 4 8 ... 이런식으로 상승할텐데 이것은 이진수의 자리수와 동일하다.
         * B를 이진수로 나타낸 뒤 위의 제곱들 중 해당하는 자리수의 경우에만 더해주면 될 것이다.
         */
        long squareVal = A;  // 현재 제곱하고 있는 중인 값
        long mult = 1;
        while(B != 0) {
            if(B % 2 == 1) {
                mult = (mult*squareVal)%C;
            }
            B = B >> 1;
            squareVal = (squareVal * squareVal)% C;
        }

        System.out.println(mult);
    }
}