import java.util.*;

class Solution {
    // points[포인트번호+1] = {r, c}
    // routes[로봇번호+1][방문순서+1] == 포인트번호+1
    // 경로는 항상 같으므로 현재 좌표와 목적지를 저장하고 있으면 이동할 수 있다.
    int[][] points, routes;
    public int solution(int[][] tPoints, int[][] tRoutes) {
        int pointLen = tPoints.length;
        points = new int[pointLen][2];
        for(int i = 0; i < pointLen; i++) {
            points[i][0] = tPoints[i][0]-1;
            points[i][1] = tPoints[i][1]-1;
        }
        int robotsLen = tRoutes.length;
        int pointNumLen = tRoutes[0].length;
        routes = new int[robotsLen][pointNumLen];
        for(int i = 0; i < robotsLen; i++) {
            for(int j = 0; j < pointNumLen; j++) {
                routes[i][j] = tRoutes[i][j] - 1;
            }
        }
        
        int[] nr = new int[robotsLen];
        int[] nc = new int[robotsLen];
        int[] pointNum = new int[robotsLen];    // 현재 몇번째 포인트 번호
        int cnt = 0;    // 충돌위험 개수
        int activeRobot = robotsLen;
        for(int i = 0; i < robotsLen; i++) {
            int p = routes[i][0];
            int sr = points[p][0];
            int sc = points[p][1];
            nr[i] = sr;
            nc[i] = sc;
            pointNum[i] = 1;
        }
        
        boolean[] finished = new boolean[robotsLen];
        while(activeRobot > 0) {
            int[][] count = new int[100][100];
            
            for(int i = 0; i < robotsLen; i++) {
                if(finished[i]) continue;
                count[nr[i]][nc[i]]++;
            }
            
            for(int i = 0; i < 100; i++) {
                for(int j = 0; j < 100; j++) {
                    if(count[i][j] >= 2) cnt++;
                }
            }
            
            for(int i = 0; i < robotsLen; i++) {
                if(finished[i]) continue;
                
                if (pointNum[i] == pointNumLen) {
                    finished[i] = true;
                    activeRobot--;
                    continue;
                }
                
                int targetPoint = routes[i][pointNum[i]];
                int dr = points[targetPoint][0];
                int dc = points[targetPoint][1];
                if(dr != nr[i]) {
                    if(dr > nr[i]) {
                        nr[i]++;
                    } else {
                        nr[i]--;
                    }
                } else if(dc != nc[i]) {
                    if(dc > nc[i]) {
                        nc[i]++;
                    } else {
                        nc[i]--;
                    }
                } 
                
                if(nr[i] == dr && nc[i] == dc){
                    pointNum[i]++;
                }
            }
        }
        
        return cnt;
    }
}