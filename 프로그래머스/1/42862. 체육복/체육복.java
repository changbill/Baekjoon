import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int[] clothes = new int[n+1];
        Arrays.fill(clothes, 1);
        for(int l : lost) {
            clothes[l]--;
        }
        
        for(int r : reserve) {
            clothes[r]++;
        }
        
        for(int i = 1; i <= n; i++) {
            if(clothes[i] == 0 && i-1 > 0 && clothes[i-1] == 2) {
                clothes[i-1] = 1;
                clothes[i] = 1;
                continue;
            }
            
            if(clothes[i] == 0 && i+1 <= n && clothes[i+1] == 2) {
                clothes[i+1] = 1;
                clothes[i] = 1;
                continue;
            }
        }
        
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(clothes[i] == 1 || clothes[i] == 2) cnt++;
        }
        int answer = cnt;
        return answer;
    }
}