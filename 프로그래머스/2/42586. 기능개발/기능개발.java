import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            int left = 100 - progresses[i];
            int oneorzero = left % speeds[i] == 0 ? 0 : 1;
            int timetaken = left / speeds[i] + oneorzero;
            if(dq.isEmpty()) {
                dq.offerFirst(timetaken);
            } else {
                int first = dq.peekLast();
                if(first >= timetaken) {
                    dq.offerFirst(timetaken);
                } else {
                    list.add(dq.size());
                    while(!dq.isEmpty()) {
                        dq.pollLast();
                    }
                    dq.offerFirst(timetaken);
                }
            }
        }
        
        if(!dq.isEmpty()) {
            list.add(dq.size());
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}