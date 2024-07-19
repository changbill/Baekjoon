import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int toNodeNum;
        int dist;
        Node(int toNodeNum, int dist) {
            this.toNodeNum = toNodeNum;
            this.dist = dist;
        }
    }

    static List<Node>[] list;
    static boolean[] flag;
    static int max, endPoint;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        for(int v = 1; v <= V; v++) {
            list[v] = new ArrayList<>();
        }

        for(int v = 1; v <= V; v++) {
            st = new StringTokenizer(br.readLine());
            int fromNodeNum = Integer.parseInt(st.nextToken());
            while(true) {
                int toNodeNum = Integer.parseInt(st.nextToken());
                if(toNodeNum == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                list[fromNodeNum].add(new Node(toNodeNum, dist));
            }
        }

        flag = new boolean[V+1];
        max = 0;
        endPoint = -1;
        dfs(1, 0);
        max = 0;
        flag = new boolean[V+1];
        dfs(endPoint, 0);
        System.out.println(max);
    }

    static void dfs(int fromNodeNum, int dist) {
        flag[fromNodeNum] = true;
        for (int i = 0; i < list[fromNodeNum].size(); i++) {
            Node toNode = list[fromNodeNum].get(i);
            if(flag[toNode.toNodeNum]) continue;

            dfs(toNode.toNodeNum, dist+toNode.dist);
        }
        if(dist > max) {
            max = dist;
            endPoint = fromNodeNum;
        }
    }
}