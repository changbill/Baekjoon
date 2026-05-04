class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1; // 기본적으로 오른쪽으로 쭉 가는 경우

        for (int i = 0; i < len; i++) {
            // 1. 상하 조작: 알파벳 만들기
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // 2. 좌우 조작: 다음 글자가 A인 경우 얼마나 건너뛸지 계산
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            // i: 현재까지 온 거리
            // len - next: 뒤에서부터 남은 거리
            
            // i * 2 + (len - next): 오른쪽으로 갔다가 다시 왼쪽으로 꺾기
            move = Math.min(move, i * 2 + (len - next));
            // (len - next) * 2 + i: 왼쪽으로 먼저 갔다가 다시 오른쪽으로 꺾기
            move = Math.min(move, (len - next) * 2 + i);
        }

        return answer + move;
    }
}