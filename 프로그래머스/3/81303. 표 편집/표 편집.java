import java.util.*;

class Solution {
    int now, n;
    char[] maps;
    public String solution(int z, int k, String[] cmd) {
        int cmdLen = cmd.length;
        now = k;        // 0부터
        n = z;
        boolean[] deleted = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int[] prev = new int[n];
        int[] next = new int[n];
        for(int i = 0; i < n; i++) {
            prev[i] = i-1;
            next[i] = i+1;
        }
        next[n-1] = -1;
        
        for(int i = 0; i < cmdLen; i++) {
            char comm = cmd[i].charAt(0);
            
            if(comm == 'U' || comm == 'D') {
                int dist = Integer.parseInt(cmd[i].substring(2));
                if(comm == 'U') {
                    for(int j = 0; j < dist; j++) {
                        now = prev[now];
                    }
                } else {
                    for(int j = 0; j < dist; j++) {
                        now = next[now];
                    }
                }
                continue;
            }
            
            if(comm == 'C') {
                deleted[now] = true;    // 삭제한 원소 저장
                stack.offerLast(now);   // 삭제 최신순
                if(next[now] != -1) {
                    prev[next[now]] = prev[now];
                }
                
                if(prev[now] != -1) {
                    next[prev[now]] = next[now];
                }
                
                if(next[now] == -1) {
                    now = prev[now];
                } else {
                    now = next[now];
                }
                continue;
            }
            
            if(comm == 'Z') {
                int paste = stack.pollLast();
                deleted[paste] = false;
                if(prev[paste] != -1) {
                    next[prev[paste]] = paste;
                }
                
                if(next[paste] != -1) {
                    prev[next[paste]] = paste;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(deleted[i] ? 'X' : 'O');
        }
        
        String answer = sb.toString();
        return answer;
    }
}