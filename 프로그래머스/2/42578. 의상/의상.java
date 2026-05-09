import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        Iterator<Integer> it = map.values().iterator();
        
        while (it.hasNext()) {
            answer *= (it.next() + 1);
        }
        
        return answer - 1;
    }
}