import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int idx1 = 0, idx2 = 0, idx3 = 0, cnt1 = 0, cnt2 = 0, cnt3 = 0;
        for(int i = 0; i < answers.length; i++) {
            if(idx1 == 5) idx1 = 0;
            if(idx2 == 8) idx2 = 0;
            if(idx3 == 10) idx3 = 0;
            if(answers[i] == one[idx1++]) {
                cnt1++;
            }
            if(answers[i] == two[idx2++]) {
                cnt2++;
            }
            if(answers[i] == three[idx3++]) {
                cnt3++;
            }
        }
        
        int max = Math.max(Math.max(cnt1, cnt2), cnt3);
        List<Integer> list = new ArrayList<>();
        if(cnt1 == max) list.add(1);
        if(cnt2 == max) list.add(2);
        if(cnt3 == max) list.add(3);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}