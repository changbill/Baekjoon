import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] rainTime = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(rainTime[i], INF);
        }

        for (int t = 0; t < drops.length; t++) {
            int r = drops[t][0];
            int c = drops[t][1];
            rainTime[r][c] = t + 1;
        }

        // rowMin[r][c] = r행에서 c ~ c+w-1 구간의 최소 비 시점
        int[][] rowMin = new int[m][n - w + 1];

        for (int r = 0; r < m; r++) {
            Deque<Integer> deque = new ArrayDeque<>();

            for (int c = 0; c < n; c++) {
                while (!deque.isEmpty() && deque.peekFirst() <= c - w) {
                    deque.pollFirst();
                }

                while (!deque.isEmpty() && rainTime[r][deque.peekLast()] >= rainTime[r][c]) {
                    deque.pollLast();
                }

                deque.offerLast(c);

                if (c >= w - 1) {
                    rowMin[r][c - w + 1] = rainTime[r][deque.peekFirst()];
                }
            }
        }

        int bestTime = -1;
        int[] answer = new int[]{0, 0};

        // col 기준으로 세로 h 구간 최소값 계산
        for (int c = 0; c < n - w + 1; c++) {
            Deque<Integer> deque = new ArrayDeque<>();

            for (int r = 0; r < m; r++) {
                while (!deque.isEmpty() && deque.peekFirst() <= r - h) {
                    deque.pollFirst();
                }

                while (!deque.isEmpty() && rowMin[deque.peekLast()][c] >= rowMin[r][c]) {
                    deque.pollLast();
                }

                deque.offerLast(r);

                if (r >= h - 1) {
                    int topRow = r - h + 1;
                    int firstRainTime = rowMin[deque.peekFirst()][c];

                    if (firstRainTime > bestTime ||
                        (firstRainTime == bestTime &&
                            (topRow < answer[0] || 
                             (topRow == answer[0] && c < answer[1])))) {

                        bestTime = firstRainTime;
                        answer[0] = topRow;
                        answer[1] = c;
                    }
                }
            }
        }

        return answer;
    }
}