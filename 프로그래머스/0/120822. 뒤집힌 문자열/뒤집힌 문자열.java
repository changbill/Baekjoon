import java.util.*;

class Solution {
    public String solution(String my_string) {
        char[] carr = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < carr.length; i++) {
            sb.append(carr[carr.length-1-i]);
        }
        String answer = sb.toString();
        return answer;
    }
}