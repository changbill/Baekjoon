import java.util.*;

class Solution {
    int[] diffs, times;
    long limit;
    int n;
    public int solution(int[] a, int[] b, long c) {
        diffs = a;
        times = b;
        limit = c;
        n = diffs.length;   // 퍼즐 개수

        int left = 1;
        int right = 100000;
        // 내 숙련도 level 기준으로 이분탐색
        while(left < right) {
            int mid = (right - left) / 2 + left;
            // mid 성공 시
            if(puzzle(mid)) {
                right = mid;
            // mid 실패 시
            } else { 
                left = mid+1;
            }
        }
        
        return left;
    }
    
    boolean puzzle(int level) {
        // diff <= level: time_cur 시간 소요
        // diff > level: (diff-level) * (time_cur + time_prev) + time_cur
        // 제한 시간: limit
        long sum = 0;
        for(int i = 0; i < n; i++) {
            int diff = diffs[i];
            int time = times[i];
            if(diff <= level) {
                sum += time;
            } else {
                int prev = times[i-1];
                sum += (diff - level) * (time + prev) + time;
            }
        }
        return limit >= sum;
    }
}
// 퍼즐 난이도 diff
// 현재 퍼즐 소요시간 time_cur
// 이전 퍼즐 소요시간 time_prev
// 숙련도 level
// diff <= level이면 time_cur만에 해결, diff > level이면 diff - level만큼 틀림
// 틀릴때마다 time_cur만큼 시간 사용, 추가로 time_prev만큼의 시간을 사용해 이전 퍼즐 풀고 와야함

// int n;
//     int[] diffs, times;
//     long limit;
//     public int solution(int[] diffs, int[] times, long limit) {
//         // 숙련도의 최솟값을 구하는 문제
//         // 숙련도를 이분탐색으로 구하기?
//         n = diffs.length;
//         this.diffs = diffs;
//         this.times = times;
//         this.limit = limit;
        
//         int left = 1;
//         int right = 100000;
//         while(left <= right) {
//             int mid = (right - left) / 2 + left;
//             if(canSolvPuzz(mid)) {
//                 right = mid - 1;
//                 continue;
//             }
//             left = mid + 1;
//         }
        
//         int answer = left;
//         return answer;
//     }
    
//     boolean canSolvPuzz(int level) {
//         long cnt = 0L;
//         for(int i = 0; i < n; i++) {
//             if(diffs[i] <= level) {
//                 cnt += times[i];
//             } else {
//                 cnt += (diffs[i] - level) * (times[i] + times[i-1]) + times[i];
//             }
//         }
        
//         return cnt <= limit;