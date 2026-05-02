import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int pmax = participant.length;
        int cmax = completion.length;
        int pidx = 0;
        int cidx = 0;
        
        while(pidx < pmax && cidx < cmax) {
            if(participant[pidx].equals(completion[cidx])) {
                pidx++;
                cidx++;
            } else {
                return participant[pidx];
            }
        }
        
        return participant[pidx];
    }
}