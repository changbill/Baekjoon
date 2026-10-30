import java.util.*;

class Solution {
    int[][] arr = {{1,2,3,4,5},{2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    public int[] solution(int[] answers) {
        int len = answers.length;
        int[] quest = new int[3];
        for(int i = 0; i < 3; i++) {
            int rot = arr[i].length;
            for(int j = 0; j < len; j++) {
                if(answers[j] == arr[i][j % rot]) {
                    quest[i]++;
                }
            }
        }
        
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(max < quest[i]) {
                max = quest[i];
                list = new ArrayList<>();
                list.add(i+1);
            } else if(max == quest[i]) {
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}