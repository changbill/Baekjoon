import java.util.*;

class Solution {
    int n, len;
    int[][] wires;
    List<List<Integer>> edges;
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        this.n = n;
        this.wires = wires;
        len = wires.length;
        int min = Integer.MAX_VALUE;
        edges = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        
        for(int i = 0; i < len; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            edges.get(v1).add(v2);
            edges.get(v2).add(v1);
        }
        
        for(int i = 0; i < len; i++) {
            Integer v1 = wires[i][0];
            Integer v2 = wires[i][1];
            edges.get(v1).remove(v2);
            edges.get(v2).remove(v1);
            int n1 = bfs(v1);
            int n2 = bfs(v2);
            min = Math.min(min, Math.abs(n1 - n2));
            edges.get(v1).add(v2);
            edges.get(v2).add(v1);
        }
        
        int answer = min;
        return answer;
    }
    
    int bfs(int node) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(node);
        visited = new boolean[n+1];
        visited[node] = true;
        int cnt = 0;
        
        while(!dq.isEmpty()) {
            int now = dq.poll();
            cnt++;
            visited[now] = true;
            for(int t : edges.get(now)) {
                if(!visited[t]) {
                    dq.add(t);
                }
            }
        }
        
        return cnt;
    }
}