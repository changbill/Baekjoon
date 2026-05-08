import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        String prev = "s";
        loop:
        for(String str : phone_book) {
            if(prev.length() <= str.length()) {
                for(int i = 0; i < prev.length(); i++) {
                    if(prev.charAt(i) != str.charAt(i)) {
                        prev = str;
                        continue loop;
                    }
                }
                return false;
            }
            prev = str;
        }
        
        return true;
    }
}