import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        TreeMap<String, TrieNode> children = new TreeMap<>();
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        TrieNode root = new TrieNode();
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            TrieNode node = root;
            for(int k = 1; k <= K; k++) {
                String feed = st.nextToken().toString();
                node = insert(node, feed);
            }
        }

        dfs(root, 0);

        System.out.println(sb);
    }

    static TrieNode insert(TrieNode node, String feed) {
        ;
        if(node.children.containsKey(feed)) {
            TrieNode next = node.children.get(feed);
            return next;
        } else {
            TrieNode next = new TrieNode();
                    node.children.put(feed, next);
            return next;
        }
    }

    static void dfs(TrieNode node, int depth) {
        for(Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            for(int i = 0; i < depth; i++) {
                sb.append("--");
            }
            sb.append(entry.getKey() + "\n");
            dfs(entry.getValue(), depth + 1);
        }
    }
}