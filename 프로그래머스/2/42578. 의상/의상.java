import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String[] cloth : clothes) {
            String name = cloth[0];
            String type = cloth[1];
            
            List<String> list;
            if(map.containsKey(type)) {
                list = map.get(type);
            } else {
                list = new ArrayList<>();
                map.put(type, list);
            }
            list.add(name);
        }
        
        int answer = 1;
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            int len = list.size();
            answer *= len+1;
        }
        
        return answer -1;
    }
}










// import java.util.*;

// class Solution {
//     public int solution(String[][] clothes) {
//         HashMap<String, Integer> map = new HashMap<>();
        
//         for (String[] cloth : clothes) {
//             String type = cloth[1];
//             map.put(type, map.getOrDefault(type, 0) + 1);
//         }
        
//         int answer = 1;
//         Iterator<Integer> it = map.values().iterator();
        
//         while (it.hasNext()) {
//             answer *= (it.next() + 1);
//         }
        
//         return answer - 1;
//     }
// }