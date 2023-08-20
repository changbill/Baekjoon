import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('(', 0); // 우선순위로 체크할 건 스택내부에서만 할 것이므로

        String str = br.readLine();
        char[] Arr = str.toCharArray();
        char[] backArr = new char[Arr.length];
        int idx = 0;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<Arr.length; i++) {
            if(Arr[i] >= 'A' && Arr[i] <= 'Z') { // 피연산자라면

                backArr[idx++] = Arr[i]; // 피연산자 배열에 담기

            } else { // 연산자라면

                if (Arr[i] == '(') {
                    stack.push(Arr[i]);
                } else if (stack.isEmpty()) {
                    stack.push(Arr[i]);
                } else if (Arr[i] == '*' || Arr[i] == '/' ||Arr[i] == '-' ||Arr[i] == '+') {
                    if(priority.get(Arr[i])>priority.get(stack.peek())) {
                        stack.push(Arr[i]);
                    } else {
                        while(!(stack.isEmpty() || priority.get(Arr[i])>priority.get(stack.peek()))) {
                            backArr[idx++] = stack.pop();
                        }
                        stack.push(Arr[i]);
                    }
                } else {
                    while(true) {
                        char p;
                        if((p = stack.pop()) == '(') {
                            break;
                        } else {
                            backArr[idx++] = p;
                        }
                    }
                }
            }
        } // 숫자는 배열에, 연산자는 스택에

        if (!stack.isEmpty()) {
            while(!stack.isEmpty()) {
                backArr[idx++] = stack.pop();
            }
        }

        int idx2 = 0;
        while(idx2 < Arr.length && backArr[idx2] != '\0') {
            sb.append(backArr[idx2++]);
        }

        System.out.println(sb);
    }
}