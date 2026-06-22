import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        int[][] timestamp = new int[n][3];
        for(int i = 0; i < n; i++) {
            timestamp[i][0] = jobs[i][0];
            timestamp[i][1] = jobs[i][1];
            timestamp[i][2] = i;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] != b[1]) {
                return a[1] - b[1];
            }
            if(a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[2] - b[2];
        });
        
        Arrays.sort(timestamp, (a,b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            }
            if(a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });
        
        int answer = 0;
        int now = 0;
        for(int i = 0; i < n; i++) {
            int idx = i;
            while(!pq.isEmpty()) {
                // HD
                int[] task = pq.poll();
                if(now > task[0]) {
                    now += task[1];
                } else {
                    now = task[0] + task[1];
                }
                answer += now-task[0];
                
                // 작업동안 밀린 작업 요청 대기큐에 채우기
                while(idx < n && now >= timestamp[idx][0]) {
                    int[] tmp = new int[3];
                    tmp[0] = timestamp[idx][0];
                    tmp[1] = timestamp[idx][1];
                    tmp[2] = timestamp[idx++][2];
                    pq.add(tmp);
                }
            }
            i = idx;
            
            if(i < n) {
                int[] tmp = new int[3];
                tmp[0] = timestamp[i][0];
                tmp[1] = timestamp[i][1];
                tmp[2] = timestamp[i][2];
                pq.add(tmp);
                now = timestamp[i][0];
            }
        }
        while(!pq.isEmpty()) {
                // HD
                int[] task = pq.poll();
                if(now > task[0]) {
                    now += task[1];
                } else {
                    now = task[0] + task[1];
                }
                answer += now-task[0];
            }
        
        
        return answer/n;
    }
}