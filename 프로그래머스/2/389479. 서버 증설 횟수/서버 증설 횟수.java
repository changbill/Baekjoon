class Solution {
    public int solution(int[] players, int m, int k) {
        int n = players.length;
        int[] serverArr = new int[n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int serverCnt = serverArr[i];
            int serverNeeds = players[i] / m;
            if(serverCnt >= serverNeeds) continue;
            int addServer = serverNeeds - serverCnt;
            cnt += addServer;
            for(int j = 0; j < k && i+j < n; j++) {
                serverArr[i+j] += addServer;
            }
        }

        return cnt;
    }
}

// int[] dp = new int[24];
//         int capa = m;
//         int dura = k;
//         int cnt = 0;
//         for(int i = 0; i < 24; i++) {
//             int tmp = players[i] / capa;
//             if(tmp > dp[i]) {
//                 int add = tmp - dp[i];
//                 cnt += add;
//                 for(int j = 0; j < dura; j++) {
//                     if(i+j < 24) {
//                         dp[i+j] += add;
//                     }
//                 }
//             }
//         }
        
//         int answer = cnt;