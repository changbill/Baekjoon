import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> strmCntMap = new HashMap<>();
        Map<String, List<Integer>> idxMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            strmCntMap.put(genre, strmCntMap.getOrDefault(genre,0) + play);
            
            idxMap.putIfAbsent(genre, new ArrayList<>());
            idxMap.get(genre).add(i);
        }
        
        List<Map.Entry<String, Integer>> strmCntList = new ArrayList<>(strmCntMap.entrySet());
        strmCntList.sort(Map.Entry.comparingByValue((a, b) -> b - a));
        
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<String, Integer> strmCnt : strmCntList) {
            String genre = strmCnt.getKey();
            List<Integer> idxList = idxMap.get(genre);
            idxList.sort((a,b) -> {
                if(plays[b] != plays[a]) {
                    return plays[b] - plays[a];
                }
                return a - b;
            });
            
            int end = Math.min(2, idxList.size());
            for(int i = 0; i < end; i++) {
                list.add(idxList.get(i));
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
/*
map 장르, 전체 재생횟수
map 장르, 고유번호 list 재생횟수 순, 고유번호 낮은 순 정렬
*/