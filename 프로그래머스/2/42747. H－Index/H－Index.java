import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        
        Arrays.sort(citations);
        int answer = 0;
        // 0인 경우
        if(citations[0] >= n) {
            answer = n;
        }
        
        for(int i = 1; i < n; i++) {
            int h = n-i;    // H 인덱스 내림차순
            
            if(citations[i] >= h && citations[i-1] <= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}