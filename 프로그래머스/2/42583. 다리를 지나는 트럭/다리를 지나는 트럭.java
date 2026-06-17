import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int n = truck_weights.length;
        int sum = 0;
        int cnt = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            int now = truck_weights[i];
            while(true) {
                // 넣을 수 있을 시(weight가 견디면)
                // 트럭 다리에 넣음
                cnt++;
                if(sum + now <= weight) {
                    dq.offerLast(now);
                    sum += now;
                    if(dq.size() == bridge_length) {
                        int out = dq.pollFirst();
                        sum -= out;
                    }
                    break;
                } else {
                    // 못넣으면 0 집어넣기
                    dq.offerLast(0);
                }

                // dq size가 bridge_length 일때
                // 트럭 다리에서 뺌
                if(dq.size() == bridge_length) {
                    int out = dq.pollFirst();
                    sum -= out;
                }
            }
        }
        
        cnt += bridge_length;
        
        int answer = cnt;
        return answer;
    }
}
/**
단, 다리에 완전히 오르지 않은 트럭의 무게는 무시
*/