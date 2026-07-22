import java.util.*;

class Solution {
    // 상 하 좌 우
    static int[][] dir = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    static int[][] NArr;
    static int max, N;
    static HashMap<Integer, List<int[]>> worm;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();

            worm = new HashMap<>();
            NArr = new int[N + 2][N + 2];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    NArr[i][j] = sc.nextInt();

                    if (NArr[i][j] >= 6 && NArr[i][j] <= 10) {
                        if (worm.containsKey(NArr[i][j])) {
                            worm.get(NArr[i][j]).add(new int[]{i, j});
                        } else {
                            List<int[]> list = new ArrayList<>();
                            list.add(new int[]{i, j});
                            worm.put(NArr[i][j], list);
                        }
                    }
                }
            }

            max = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (NArr[i][j] != 0) {
                        continue;
                    }

                    for (int k = 0; k < 4; k++) {
                        play(i, j, k);
                    }
                }
            }

            sb.append('#')
              .append(t)
              .append(' ')
              .append(max)
              .append('\n');
        }

        System.out.print(sb);
        sc.close();
    }

    static void play(int r, int c, int rot) {
        int cnt = 0;
        int tr = r;
        int tc = c;
        int d = rot;

        while (true) {
            tr += dir[d][0];
            tc += dir[d][1];

            if ((r == tr && c == tc) || NArr[tr][tc] == -1) {
                max = Math.max(max, cnt);
                return;
            }

            if (tr == 0 || tr == N + 1 || tc == 0 || tc == N + 1) {
                d = rotate(5, d);
                cnt++;
                continue;
            }

            int value = NArr[tr][tc];

            if (value >= 1 && value <= 5) {
                d = rotate(value, d);
                cnt++;
                continue;
            }

            if (value >= 6 && value <= 10) {
                for (int[] pos : worm.get(value)) {
                    if (pos[0] != tr || pos[1] != tc) {
                        tr = pos[0];
                        tc = pos[1];
                        break;
                    }
                }
            }
        }
    }

    static int rotate(int brickNum, int rot) {
        // 상 하 좌 우

        // 우상
        if (brickNum == 1) {
            if (rot == 1) return 3;
            if (rot == 2) return 0;
        }

        // 우하
        if (brickNum == 2) {
            if (rot == 0) return 3;
            if (rot == 2) return 1;
        }

        // 좌하
        if (brickNum == 3) {
            if (rot == 3) return 1;
            if (rot == 0) return 2;
        }

        // 좌상
        if (brickNum == 4) {
            if (rot == 3) return 0;
            if (rot == 1) return 2;
        }

        // 벽 또는 블록의 평면
        if (rot == 3) {
            return 2;
        }

        if (rot == 2) {
            return 3;
        }

        if (rot == 1) {
            return 0;
        }

        return 1;
    }
}