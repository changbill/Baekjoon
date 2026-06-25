import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n; i++) {
            set.add(nums[i]);
        }
        
        if(set.size() > n/2) return n/2;
        
        return set.size();
    }
}










// import java.util.*;

// class Solution {
//     public int solution(int[] nums) {
//         Set<Integer> set = new HashSet<>();
//         for(int i = 0; i < nums.length; i++) {
//             set.add(nums[i]);
//         }
        
//         int answer = 0;
//         if(nums.length / 2 >= set.size()) {
//             answer = set.size();
//         } else {
//             answer = nums.length / 2;
//         }
        
//         return answer;
//     }
// }