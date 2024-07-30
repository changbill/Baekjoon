import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if(str.equals(".")) break;
            char[] arr = str.toCharArray();
            Stack<Character> bracket = new Stack<>();
            loop:
            for(int i =0; i < arr.length; i++) {
                switch(arr[i]) {
                    case '(':
                        bracket.push('(');
                        break;
                    case ')':
                        if(bracket.isEmpty() || bracket.peek() != '(') {
                            bracket.push('(');
                            break loop;
                        }
                        bracket.pop();
                        break;
                    case '[':
                        bracket.push('[');
                        break;
                    case ']':
                        if(bracket.isEmpty() || bracket.peek() != '[') {
                            bracket.push('[');
                            break loop;
                        }
                        bracket.pop();
                        break;
                }
            }

            if(bracket.isEmpty()) {
                sb.append("yes"+"\n");
                continue;
            }
            sb.append("no"+"\n");
        }

        System.out.println(sb);
    }
}