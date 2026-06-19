class Solution {
    public int[] solution(int brown, int yellow) {
        for(int yh = 1; yh <= yellow; yh++) {
            if(yellow%yh != 0) continue;
            
            int yw = yellow/yh;
            if((yh+2)*2 + yw*2 == brown) {
                int bw = yw+2;
                int bh = yh+2;
                return new int[]{bw, bh};
            }
        }
        return new int[]{};
    }
}