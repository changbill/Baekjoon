import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();
    char[] carr;
    boolean[] visited;
    
    public int solution(String numbers) {
        boolean[] sosu = new boolean[10000000];
        Arrays.fill(sosu, true);
        sosu[0] = sosu[1] = false;
        for(int i = 2; i*i <= 9_999_999; i++) {
            if(!sosu[i]) continue;
            int idx = i;
            while(i * idx <= 9_999_999) {
                sosu[i * idx] = false;
                idx++;
            }
        }
        
        carr = numbers.toCharArray();
        visited = new boolean[carr.length];
        dfs("");
        
        Set<Integer> aset = new HashSet<>();
        for(String s : set) {
            int tmp = Integer.parseInt(s);
            if(sosu[tmp]) {
                aset.add(tmp);
            }
        }
        
        int answer = aset.size();
        return answer;
    }
    
    void dfs(String now) {
        if(!now.equals("")) {
            set.add(now);
        }
        
        for(int i = 0; i < carr.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(now+carr[i]);
            visited[i] = false;
        }
    }
}