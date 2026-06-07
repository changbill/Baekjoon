import java.util.*;

class Solution {
    public String solution(String my_string, String letter) {
        char[] carr = my_string.toCharArray();
        for(int i = 0; i < my_string.length(); i++) {
            if(carr[i] == letter.charAt(0)) {
                carr[i] = 0;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < carr.length; i++) {
            if(carr[i] != 0) {
                sb.append(carr[i]);
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}