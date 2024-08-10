import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        TrieNode children[] = new TrieNode[10];
        boolean isEnd = false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        boolean consistency = true;
        loop:
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            TrieNode root = new TrieNode();
            for(int n = 1; n <= N; n++) {
                String tel = br.readLine();
                if(!consistency) continue;
                if(!insert(root, tel)) {
                    consistency = false;
                }
            }
            if(!consistency) {
                sb.append("NO"+"\n");
                consistency = true;
                continue;
            }

            if(!checkConsistency(root)) {
                sb.append("NO" +"\n");
                continue;
            }
            sb.append("YES" + "\n");
        }

        System.out.println(sb);
    }

    static boolean insert(TrieNode node, String tel) {
        for(char number : tel.toCharArray()) {
            int tmp = number - '0';
            if(node.children[tmp] == null) {
                node.children[tmp] = new TrieNode();
            }
            node = node.children[tmp];
            if(node.isEnd) return false;
        }
        node.isEnd = true;
        return true;
    }

    static boolean checkConsistency(TrieNode node) {
        if(node.isEnd) {
            for(int i = 0; i < 10; i++) {
                if(node.children[i] != null) {
                    return false;
                }
            }
            return true;
        }

        for(TrieNode child : node.children) {
            if(child == null) continue;
            if(!checkConsistency(child)) {
                return false;
            }
        }
        return true;
    }
}