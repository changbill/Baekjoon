import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        
        for(String oper : operations) {
            st = new StringTokenizer(oper);
            char comm = st.nextToken().charAt(0);
            if(comm == 'I') {
                int num = Integer.parseInt(st.nextToken());
                maxheap.add(num);
                minheap.add(num);
            } else if(comm == 'D') {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1 && !maxheap.isEmpty()) {
                    Integer max = maxheap.poll();
                    minheap.remove(max);
                }
                if(num == -1 && !minheap.isEmpty()) {
                    Integer min = minheap.poll();
                    maxheap.remove(min);
                }
            }
        }
        
        int[] answer = new int[2];
        if(!maxheap.isEmpty()) {
            int max = maxheap.peek();
            int min = minheap.peek();
            answer[0] = max;
            answer[1] = min;
        }
        return answer;
    }
}