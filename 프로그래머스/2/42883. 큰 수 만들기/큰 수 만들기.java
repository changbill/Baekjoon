import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int len = number.length();
        for(int i = 0; i < len; i++) {
            char c = number.charAt(i);
            int tmp = c - '0';
            while(!dq.isEmpty() && dq.peekFirst() < tmp && dq.size() -1 + len - i >= len - k) {
                int x = dq.pollFirst();
            }
            dq.offerFirst(tmp);
        }
        
        while(dq.size() > len - k) {
            dq.pollFirst();
        }
        
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) {
            int tmp = dq.pollLast();
            sb.append(tmp);
        }
        
        String answer = sb.toString();
        return answer;
    }
}