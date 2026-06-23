class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] sum = new int[n];
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                sum[i] += signals[i][j];
            }
            
            start[i] = signals[i][0] + 1;
            end[i] = signals[i][0] + signals[i][1];
        }
        
        int idx = 1;
        int answer = -1;
        loop:
        while(idx < 10000000) {
            for(int i = 0; i < n; i++) {
                int tmp = idx % sum[i];
                if(tmp < start[i] || tmp > end[i]) {
                    break;
                }
                if(i == n-1) {
                    answer = idx;
                    break loop;
                }
            }
            
            idx++;
        }
        
        return answer;
    }
}