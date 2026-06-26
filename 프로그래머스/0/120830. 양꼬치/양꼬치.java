class Solution {
    public int solution(int n, int k) {
        int service = n/10;
        int beverage = k - service > 0 ? k - service : 0;
        int answer = n*12000 + beverage*2000;
        return answer;
    }
}