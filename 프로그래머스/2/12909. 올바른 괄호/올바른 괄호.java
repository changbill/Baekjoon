import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] carr = s.toCharArray();
        Deque<Boolean> dq = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            if(carr[i] == '(') {
                dq.offerFirst(true);
            } else {
                if(dq.size() == 0) return false;
                dq.pollLast();
            }
        }
        
        return dq.size() == 0 ? true : false;
    }
}