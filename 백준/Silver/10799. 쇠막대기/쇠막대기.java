import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        boolean TF = true;

        for(int i = 0; i< str.length(); i++) {
            char c = ' ';
            if ((c=str.charAt(i)) == '(') {
                stack.push(c);
                TF = true;
            } else {
                if(TF == true) {
                    stack.pop();
                    sum += stack.size();
                } else {
                    stack.pop();
                    sum +=1;
                }
                TF = false;
            }
        }
        System.out.println(sum);
    }
}