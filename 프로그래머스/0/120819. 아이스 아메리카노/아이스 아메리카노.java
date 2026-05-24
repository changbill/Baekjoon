class Solution {
    public int[] solution(int money) {
        int moks = money/5500;
        int nameoji = money%5500;
        int[] answer = {moks, nameoji};
        return answer;
    }
}