import java.util.*; 
class Solution {
    public int solution(String s) {
        Map<String, Integer> words = new HashMap<>();
        words.put("zero", 0);
        words.put("one", 1);
        words.put("two", 2);
        words.put("three", 3);
        words.put("four", 4);
        words.put("five", 5);
        words.put("six", 6);
        words.put("seven", 7);
        words.put("eight", 8);
        words.put("nine", 9);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) > '9') {
                for(int j = 3; j <= 5; j++) {
                    String str = s.substring(i,i+j);
                    if(words.containsKey(str)) {
                        sb.append(words.get(str));
                        i += j-1;
                        break;
                    }
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        int answer = Integer.parseInt(sb.toString());
        return answer;
    }
}