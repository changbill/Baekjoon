import java.util.*;

class Solution {
    int[][][] robots;
    public int solution(int[][] points, int[][] routes) {
        int robotCnt = routes.length;
        robots = new int[robotCnt][20001][2];
        int pointsCnt = points.length;
        int maxTime = 0;
        
        for(int i = 0; i < robotCnt; i++) {
            List<Integer> spots = new ArrayList<>();
            for(int j = 0; j < routes[i].length; j++) {
                spots.add(routes[i][j]);
            }
            int start = spots.get(0);
            int time = 0;
            for(int j = 1; j < spots.size(); j++) {
                int to = spots.get(j);
                int sr = points[start-1][0];
                int sc = points[start-1][1];
                int tr = points[to-1][0];
                int tc = points[to-1][1];
                time = move(i, sr, sc, tr, tc, time);
                start = to;
            }
            maxTime = Math.max(maxTime, time);
        }
        
        boolean[][] visited, checked;
        int cnt = 0;
        for(int i = 0; i <= maxTime; i++) {
            visited = new boolean[101][101];
            checked = new boolean[101][101];
            boolean flag = false;
            for(int j = 0; j < robotCnt; j++) {
                if(robots[j][i][0] == 0) {
                    continue;
                }
                flag = true;
                int nr = robots[j][i][0];
                int nc = robots[j][i][1];
                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    continue;
                }
                if(!checked[nr][nc]) checked[nr][nc] = true;
            }
            if(!flag) break;
            
            for(int j = 1; j <= 100; j++) {
                for(int k = 1; k <= 100; k++) {
                    if(checked[j][k]) {
                        cnt++;
                    }
                }
            }
        }
        
        int answer = cnt;
        return answer;
    }
    
    int move(int robotNum, int sr, int sc, int tr, int tc, int time) {
        robots[robotNum][time][0] = sr;
        robots[robotNum][time][1] = sc;
        int wholeTime = Math.abs(sr - tr) + Math.abs(sc - tc);
        for(int i = 1; i <= wholeTime; i++) {
            if(sr != tr) {
                if(sr > tr) sr--;
                else sr++;
                robots[robotNum][time+i][0] = sr;
                robots[robotNum][time+i][1] = sc;
                continue;
            } 
            
            if(sc != tc) {
                if(sc > tc) sc--;
                else sc++;
                robots[robotNum][time+i][0] = sr;
                robots[robotNum][time+i][1] = sc;
                continue;
            }
        }
        return time+wholeTime;
    }
}