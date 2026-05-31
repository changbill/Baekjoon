class Solution {
    public int[] solution(int[] num_list) {
        int fst = 0;
        int sec = 0;
        for(int i = 0; i < num_list.length; i++) {
            if(num_list[i] % 2 == 0) {
                fst++;
            } else {
                sec++;
            }
        }
        
        int[] answer = {fst, sec};
        return answer;
    }
}