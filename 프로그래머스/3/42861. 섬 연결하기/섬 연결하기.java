import java.util.*;

/** MST 최소 신장 트리 문제
간선을 비용 오름차순으로 정렬한 뒤 순서대로 연결한다
이때 사이클이 발생하면 연결하지 않는다
*/
class Solution {
    // Integer[][] costs;
    // int[] parent;
    class Node {
        int nodeNum;
        int cost;
        Node(int nodeNum, int cost) {
            this.nodeNum = nodeNum;
            this.cost = cost;
        }
    }
    public int solution(int n, int[][] costs) {
        int len = costs.length;
        List<List<Node>> edges = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        
        for(int i = 0; i < len; i++) {
            int nodeA = costs[i][0];
            int nodeB = costs[i][1];
            int cost = costs[i][2];
            
            edges.get(nodeA).add(new Node(nodeB, cost));
            edges.get(nodeB).add(new Node(nodeA, cost));
        }
        
        // for(int i = 0; i < n; i++) {
        //     edges.get(i).sort((a, b) -> b.cost - a.cost);
        // }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Node(0,0));
        boolean[] visited = new boolean[n];
        int answer = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(visited[now.nodeNum]) continue;
            visited[now.nodeNum] = true;
            answer += now.cost;
            boolean check = false;
            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    check = true;
                }
            }
            if(!check) break;
            for(Node tmp : edges.get(now.nodeNum)) {
                if(!visited[tmp.nodeNum]) {
                    pq.add(new Node(tmp.nodeNum, tmp.cost));
                }
            }
        }
        
        return answer;
    }
}
        
//         int len1 = costs.length;
//         int len2 = costs[0].length;
//         this.costs = new Integer[len1][len2];
//         parent = new int[n+1];
//         for(int i = 1; i <= n; i++) {
//             parent[i] = i;
//         }
        
//         for(int i = 0; i < len1; i++) {
//             for(int j = 0; j < len2; j++) {
//                 this.costs[i][j] = costs[i][j];
//             }
//         }
        
//         int sum = 0;
//         Arrays.sort(this.costs, (a, b) -> a[2] - b[2]);
//         for(int i = 0; i < len1; i++) {
//             int a = this.costs[i][0];
//             int b = this.costs[i][1];
//             if(!union(a, b)) continue;
//             int cost = this.costs[i][2];
//             System.out.println("a: " + a + ", b: " + b + ", cost: " + cost);
//             sum += cost;
//         }
        
//         int answer = sum;
//         return answer;
//     }
    
//     int find(int x) {
//         if(parent[x] == x) return x;
//         return find(parent[x]);
//     }
    
//     boolean union(int a, int b) {
//         int parentA = find(a);
//         int parentB = find(b);
        
//         if(parentA == parentB) return false;
//         if(parentB > parentA) {
//             parent[parentB] = parentA;
//         } else {
//             parent[parentA] = parentB;
//         }
//         return true;
//     }
// }