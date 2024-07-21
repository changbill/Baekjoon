import java.io.*;
import java.util.*;

public class Main {

    static class Shark {
        int r, c, dist;
        Shark(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static int N, NArr[][], size, stack, time, locR, locC;
    static int delR[] = {-1,0,0,1};
    static int delC[] = {0,-1,1,0};
    static boolean flag[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        NArr = new int[N+1][N+1];
        size = 2;
        stack = 0;
        time = 0;
        locR = 0; locC = 0;

        for(int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= N; c++) {
                NArr[r][c] = Integer.parseInt(st.nextToken());
                if(NArr[r][c] == 9) {
                    locR = r;
                    locC = c;
                    NArr[r][c] = 0;
                }
            }
        }

        while(bfs(locR, locC)) {}

        System.out.println(time);
    }

    static boolean bfs(int r, int c) {
        PriorityQueue<Shark> pq = new PriorityQueue<>(
                (s1, s2) -> {
                    if(s1.dist != s2.dist) {
                        return Integer.compare(s1.dist, s2.dist);
                    }
                    if(s1.r != s2.r) {
                        return Integer.compare(s1.r, s2.r);
                    }
                    return Integer.compare(s1.c, s2.c);
                }
        );
        pq.add(new Shark(r, c, 0));
        flag = new boolean[N+1][N+1];
        flag[r][c] = true;

        while(!pq.isEmpty()) {
            Shark shark = pq.poll();
            if(NArr[shark.r][shark.c] < size && NArr[shark.r][shark.c] != 0) {
                NArr[shark.r][shark.c] = 0;
                time += shark.dist;
                stack++;
                locR = shark.r;
                locC = shark.c;
                if(stack == size) {
                    size++;
                    stack = 0;
                }
                return true;
            }
            for(int d = 0; d < 4; d++) {
                int dr = delR[d] + shark.r;
                int dc = delC[d] + shark.c;
                int dist = shark.dist + 1;
                if(dr <= N && dc <= N && dr > 0 && dc > 0 && !flag[dr][dc] && NArr[dr][dc] <= size) {
                    flag[dr][dc] = true;
                    pq.add(new Shark(dr, dc, dist));
                }
            }
        }
        return false;
    }
}