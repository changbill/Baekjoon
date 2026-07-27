import java.util.*;

class Solution {
    int[] numbers, left, right;
    int[][] phone;
    String hand;
    int[] dr = {0,0,-1,1};
    int[] dc = {1,-1,0,0};
    public String solution(int[] z, String x) {
        numbers = z;
        hand = x;
        phone = new int[5][4];
        left = new int[]{4,1};
        right = new int[]{4,3};
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            switch(num) {
                case 1:
                    sb.append('L');
                    left[0] = 1;
                    left[1] = 1;
                    break;
                case 4:
                    sb.append('L');
                    left[0] = 2;
                    left[1] = 1;
                    break;
                case 7:
                    sb.append('L');
                    left[0] = 3;
                    left[1] = 1;
                    break;
                case 3:
                    sb.append('R');
                    right[0] = 1;
                    right[1] = 3;
                    break;
                case 6:
                    sb.append('R');
                    right[0] = 2;
                    right[1] = 3;
                    break;
                case 9:
                    sb.append('R');
                    right[0] = 3;
                    right[1] = 3;
                    break;
                case 2:
                    if(whichHand(1,2)) {
                        // true: left, false: right
                        sb.append('L');
                        left[0] = 1;
                        left[1] = 2;
                    } else {
                        sb.append('R');
                        right[0] = 1;
                        right[1] = 2;
                    }
                    break;
                case 5:
                    if(whichHand(2,2)) {
                        sb.append('L');
                        left[0] = 2;
                        left[1] = 2;
                    } else {
                        sb.append('R');
                        right[0] = 2;
                        right[1] = 2;
                    }
                    break;
                case 8:
                    if(whichHand(3,2)) {
                        sb.append('L');
                        left[0] = 3;
                        left[1] = 2;
                    } else {
                        sb.append('R');
                        right[0] = 3;
                        right[1] = 2;
                    }
                    break;
                case 0:
                    if(whichHand(4,2)) {
                        sb.append('L');
                        left[0] = 4;
                        left[1] = 2;
                    } else {
                        sb.append('R');
                        right[0] = 4;
                        right[1] = 2;
                    }
                    break;
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
    
    boolean whichHand(int r, int c) {
        // 가까운 순 먼저
        int leftDist = Math.abs(left[0] - r) + Math.abs(left[1] - c);
        int rightDist = Math.abs(right[0] - r) + Math.abs(right[1] - c);
        if(leftDist != rightDist) return leftDist < rightDist;
        // 같다면 어느쪽 손잡이
        return hand.equals("left");
    }
}