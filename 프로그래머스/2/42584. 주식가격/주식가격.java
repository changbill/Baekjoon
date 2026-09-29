import java.util.*;

class Solution {
    class Node {
        int start;
        int price;
        Node(int start, int price) {
            this.start = start;
            this.price = price;
        }
    }
    public int[] solution(int[] prices) {
        int len = prices.length;
        Deque<Node> dq = new ArrayDeque<>();
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) {
            while(!dq.isEmpty() && dq.peekFirst().price > prices[i]) {
                Node node = dq.pollFirst();
                answer[node.start] = i - node.start;
            }
            dq.offerFirst(new Node(i, prices[i]));
        }
        while(!dq.isEmpty()) {
            Node node = dq.pollFirst();
            answer[node.start] = len-1-node.start;
        }
        return answer;
    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         int n = prices.length;
//         int[] answer = new int[n];
//         Deque<Integer> dq = new ArrayDeque<>();
//         for(int i = 0; i < n; i++) {
//             while(!dq.isEmpty() && prices[dq.peekLast()] > prices[i]) {
//                 int idx = dq.pollLast();
//                 answer[idx] = i - idx;
//             }
//             dq.offerLast(i);
//         }
        
//         while(!dq.isEmpty()) {
//             int idx = dq.pollLast();
//             answer[idx] = n - 1 - idx;
//         }
        
//         return answer;
//     }
// }