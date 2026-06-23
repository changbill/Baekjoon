import java.util.*;

class Solution {
    List<List<List<Integer>>> edgeList;
    boolean[] visited;
    private Set<Integer> connect(int from, int type) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = edgeList.get(from).get(type);
        visited[from] = true;
        set.addAll(list);
        for(Integer t : list) {
            if(visited[t]) continue;
            set.addAll(connect(t, type));
        }
        return set;
    }
    public int solution(int n, int infection, int[][] edges, int k) {
        edgeList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            edgeList.add(new ArrayList<>());
            for(int j = 0; j <= 3; j++) {
                edgeList.get(i).add(new ArrayList<>());
            }
        }
        
        int m = edges.length;
        for(int i = 0; i < m; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int type = edges[i][2];
            edgeList.get(x).get(type).add(y);
            edgeList.get(y).get(type).add(x);
        }
        
        Deque<Set<Integer>> q = new ArrayDeque<>();
        Set<Integer> firstSet = new HashSet<>();
        firstSet.add(infection);
        q.offer(firstSet);
        Set<Set<Integer>> newQ = new HashSet<>();
        for(int i = 0; i < k; i++) {
            while(!q.isEmpty()) {
                Set<Integer> set = q.poll();
                Set<Integer> newSet;
                for(int j = 1; j <= 3; j++) {
                    newSet = new HashSet<>(set);
                    visited = new boolean[n+1];
                    for(Integer tmp : set) {
                        newSet.addAll(connect(tmp, j));
                    }
                    newQ.add(newSet);
                }
            }
            for(Set<Integer> tmp : newQ) {
                q.offer(tmp);
            }
        }
        
        int max = 0;
        for(Set<Integer> tmp : q) {
            max = Math.max(max, tmp.size());
        }
        
        int answer = max;
        return answer;
    }
}