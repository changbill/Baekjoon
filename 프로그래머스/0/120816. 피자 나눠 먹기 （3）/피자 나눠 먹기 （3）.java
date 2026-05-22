class Solution {
    public int solution(int slice, int n) {
        int answer = n/slice + (n%slice == 0 ? 0 : 1);
        return answer;
    }
}