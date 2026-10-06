import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int len = people.length;
        Arrays.sort(people);
        
        int boat = 0;
        int left = 0;
        int right = len -1;
        while(left <= right) {
            if(people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boat++;
        }
        
        int answer = boat;
        return answer;
    }
}