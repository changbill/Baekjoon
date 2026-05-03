import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int cnt = 0;
        while(pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            if(a >= K) break;
            cnt++;
            int mixed = a + b*2;
            pq.add(mixed);
        }
        if(pq.size() == 1 && pq.peek() < K) {
            return -1;
        }
        
        int answer = cnt;
        return answer;
    }
}