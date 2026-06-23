class Solution {
    int walA, walB;
    private boolean compare(int a, int b) {
        if((walA >= a && walB >= b) || (walA >= b && walB >= a)) return true;
        return false;
    }
    public int solution(int[] wallet, int[] bill) {
        walA = wallet[0];
        walB = wallet[1];
        int billA = bill[0];
        int billB = bill[1];
        
        int cnt = 0;
        while(true) {
            if(compare(billA, billB)) break;
            if(billA > billB) {
                billA /= 2;
            } else {
                billB /= 2;
            }
            cnt++;
        }
        
        int answer = cnt;
        return answer;
    }
}