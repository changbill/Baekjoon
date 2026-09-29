class Solution {
    int n, m;
    int[][] q;
    int[] ans;
    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        m = q.length;
        this.q = q;
        this.ans = ans;
        
        dfs(0,0,0);
        return answer;
    }
    
    // 1 << 1부터 시작
    void dfs(int depth, int idx, int bitmask) {
        if(depth == 5) {
            for(int i = 0; i < m; i++) {
                int sum = 0;
                for(int j = 0; j < 5; j++) {
                    sum += 1 << q[i][j];
                }
                int c = sum & bitmask;
                int cnt = 0;
                for(int j = 1; j <= n; j++) {
                    if((c & (1 << j)) > 0) cnt++;
                }
                if(cnt != ans[i]) return;
            }
            
            answer++;
        }
        
        for(int i = idx+1; i <= n; i++) {
            dfs(depth + 1, i, bitmask + (1 << i));
        }
    }
}