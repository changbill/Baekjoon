import java.util.*;

class Solution {
    int len;
    int[] nums;
    char[] chars;
    public int solution(String arr[]) {
        len = arr.length;
        nums = new int[len/2 + 1];
        chars = new char[len/2];
        int[][] maxdp = new int[len/2+1][len/2+1];
        int[][] mindp = new int[len/2+1][len/2+1];
        for(int i = 0; i <= len/2; i++) {
            for(int j = 0; j <= len/2; j++) {
                maxdp[i][j] = Integer.MIN_VALUE;
                mindp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < len; i++) {
            if(i % 2 == 0) {
                int num = Integer.parseInt(arr[i]);
                nums[i/2] = num;
                maxdp[i/2][i/2] = num;
                mindp[i/2][i/2] = num;
            } else {
                char c = arr[i].charAt(0);
                chars[i/2] = c;
            }
        }
        
        for(int diff = 1; diff <= len/2; diff++) {
            for(int range = 0; range <= len/2 - diff; range++) {
                // mid는 연산자 기준
                for(int tm = range; tm < range + diff; tm++) { 
                    int start = range;
                    int mid = tm;
                    if(chars[mid] == '-') {
                        maxdp[start][start + diff] = Math.max(maxdp[start][start + diff], maxdp[start][mid] - mindp[mid+1][start + diff]);
                        mindp[start][start + diff] = Math.min(mindp[start][start + diff], mindp[start][mid] - maxdp[mid+1][start + diff]);
                    } else {
                        maxdp[start][start + diff] = Math.max(maxdp[start][start + diff], maxdp[start][mid] + maxdp[mid+1][start + diff]);
                        mindp[start][start + diff] = Math.min(mindp[start][start + diff], mindp[start][mid] + mindp[mid+1][start + diff]);
                    }
                }
            }
        }
        
        int answer = maxdp[0][len/2];
        return answer;
    }
}