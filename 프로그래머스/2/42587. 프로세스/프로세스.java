import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int[] num = new int[10];
        Deque<Integer> dq = new ArrayDeque<>();
        Deque<Integer> idxDq = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++) {
            int p = priorities[i];
            num[p]++;
            dq.offerLast(p);
            idxDq.offerLast(i);
        }
        
        int max = 9;
        int answer = 1;
        while(!dq.isEmpty()) {
            for(int i = max; i >= 1; i--) {
                if(num[i] != 0) {
                    max = i;
                    break;
                }
            }
            
            while(true) {
                int priority = dq.pollFirst();
                int idx = idxDq.pollFirst();
                if(max != priority) {
                    dq.offerLast(priority);
                    idxDq.offerLast(idx);
                } else {
                    // 실행
                    if(idx == location) {
                        return answer;
                    }
                    answer++;
                    num[max]--;
                    break;
                }
            }
        }
               
        return answer;
    }
}