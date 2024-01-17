import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        // 폭발 문자열을 만나면 폭발시킨다.
        String explode = br.readLine();
        int strLen = str.length();
        int expLen = explode.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < strLen; i++) {
            stack.add(str.charAt(i));
            if(stack.size() >= expLen) {
            	boolean flag = true;
            	for(int j = 0; j<expLen; j++) {
            		if(stack.get(stack.size() - expLen + j) != explode.charAt(j)) {
            			flag = false;
            			break;
            		}
            	}
            	if(flag) {
        			for(int j = 0; j<expLen; j++) {
        				stack.pop();
        			}
        		}
            }
        }
        
        for(int i = 0; i < stack.size(); i++) {
        	sb.append(stack.get(i));
        }

        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
    }
}