import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.DoubleToLongFunction;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        double[] indexArr = new double[N];
        for (int i = 0; i < N; i++) {
            indexArr[i] = Double.parseDouble(br.readLine());
        } // A == 0, B == 1, ... index에 순서대로 값을 담음

        Map<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('(', 0); // 우선순위로 체크할 건 스택내부에서만 할 것이므로

        char[] backArr = str.toCharArray(); // 문자열을 char로 변환하여 배열에 담음
        Stack<Double> stack = new Stack<>(); // A, B, C ... 피연산자 담을 stack

        for(int i = 0; i<backArr.length; i++) {
            if(backArr[i] >= 'A' && backArr[i] <= 'Z') {
                for (int j = 0; j < N; j++) {
                    if(backArr[i]-'A'-j == 0) {
                        stack.push(indexArr[j]);
                    }
                }
            } else {
                if(backArr[i]=='+') { // int를 char로 바꾸면 아스키코드로 바뀐다.
                    double A = stack.pop();
                    double B = stack.pop();
                    double answer = A+B;
                    stack.push(answer);
                } else if(backArr[i] =='/') {
                    double A = stack.pop();
                    double B = stack.pop();
                    double answer = B/A;
                    stack.push(answer);
                } else if (backArr[i] == '-') {
                    double A = stack.pop();
                    double B = stack.pop();
                    double answer = B-A;
                    stack.push(answer);
                } else if (backArr[i] == '*') {
                    double A = stack.pop();
                    double B = stack.pop();
                    double answer = B*A;
                    stack.push(answer);
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}