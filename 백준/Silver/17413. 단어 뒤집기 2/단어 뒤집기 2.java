import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int i = 0;
        loop:
        while(i < str.length()) {

            if(str.charAt(i) == '<') {

                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                while(true) {
                    sb.append(str.charAt(i));
                    i++;

                    if(str.charAt(i) == '>') {
                        sb.append(str.charAt(i));
                        if(i == str.length() -1) break loop;
                        i++;
                        continue loop;
                    }

                }

            } else if(str.charAt(i) == ' ') {

                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                sb.append(str.charAt(i));
                i++;
            }

            stack.push(str.charAt(i));

            if(i == str.length() -1) {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }

            i++;

        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}