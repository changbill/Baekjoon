import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String comp : completion) {
            map.put(comp, map.getOrDefault(comp, 0) + 1);
        }
        
        for(String part : participant) {
            if(!map.containsKey(part)) {
                return part;
            }
            map.put(part, map.get(part) - 1);
            if(map.get(part) < 0) {
                return part;
            }
        }
        
        return "";
    }
}


// import java.util.*;

// class Solution {
//     public String solution(String[] participant, String[] completion) {
//         Arrays.sort(participant);
//         Arrays.sort(completion);
        
//         int pmax = participant.length;
//         int cmax = completion.length;
//         int pidx = 0;
//         int cidx = 0;
        
//         while(pidx < pmax && cidx < cmax) {
//             if(participant[pidx].equals(completion[cidx])) {
//                 pidx++;
//                 cidx++;
//             } else {
//                 return participant[pidx];
//             }
//         }
        
//         return participant[pidx];
//     }
// }