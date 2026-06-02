import java.util.*;

class Solution {
    public String solution(String my_string, int n) {
        int len = my_string.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            char c = my_string.charAt(i);
            for(int j = 0; j < n; j++) {
                sb.append(c);
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}