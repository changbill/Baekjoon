class Solution {
    public int solution(int n) {
        if(n % 2 != 0) n--;
        int tmp = (n + 2) / 2;
        
        int answer = n / 2 * tmp;
        return answer;
    }
}