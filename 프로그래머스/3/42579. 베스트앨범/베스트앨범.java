import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresPlayCnt = new HashMap<>();
        Map<String, List<Integer>> genreSongs = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            genresPlayCnt.put(genre, genresPlayCnt.getOrDefault(genre, 0) + play);
            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(i);
        }
        
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(genresPlayCnt.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        List<Integer> playList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList) {
            String genre = entry.getKey();
            List<Integer> songs = genreSongs.get(genre);
            songs.sort((a, b) -> {
                if(plays[b] == plays[a]) {
                    return a - b;
                }
                return plays[b] - plays[a];
                });
            for(int i = 0; i < 2 && i < songs.size(); i++) {
                playList.add(songs.get(i));
            }
        }
        
        int[] answer = new int[playList.size()];
        for(int i = 0; i < playList.size(); i++) {
            answer[i] = playList.get(i);
        }
        
        return answer;
    }
}

// class Solution {
//     public int[] solution(String[] genres, int[] plays) {
//         Map<String, Integer> strmCntMap = new HashMap<>();
//         Map<String, List<Integer>> idxMap = new HashMap<>();
//         for(int i = 0; i < genres.length; i++) {
//             String genre = genres[i];
//             int play = plays[i];
//             strmCntMap.put(genre, strmCntMap.getOrDefault(genre,0) + play);
            
//             idxMap.putIfAbsent(genre, new ArrayList<>());
//             idxMap.get(genre).add(i);
//         }
        
//         List<Map.Entry<String, Integer>> strmCntList = new ArrayList<>(strmCntMap.entrySet());
//         strmCntList.sort(Map.Entry.comparingByValue((a, b) -> b - a));
        
//         List<Integer> list = new ArrayList<>();
//         for(Map.Entry<String, Integer> strmCnt : strmCntList) {
//             String genre = strmCnt.getKey();
//             List<Integer> idxList = idxMap.get(genre);
//             idxList.sort((a,b) -> {
//                 if(plays[b] != plays[a]) {
//                     return plays[b] - plays[a];
//                 }
//                 return a - b;
//             });
            
//             int end = Math.min(2, idxList.size());
//             for(int i = 0; i < end; i++) {
//                 list.add(idxList.get(i));
//             }
//         }
        
//         int[] answer = new int[list.size()];
//         for(int i = 0; i < list.size(); i++) {
//             answer[i] = list.get(i);
//         }
//         return answer;
//     }
// }