import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int key;
        Node left, right;
        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }

        void insert(int tmp) {
            if(tmp < this.key) {
                if(this.left == null) {
                    this.left = new Node(tmp);
                } else {
                    this.left.insert(tmp);
                }
            } else {
                if(this.right == null) {
                    this.right = new Node(tmp);
                } else {
                    this.right.insert(tmp);
                }
            }
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str = "";
        Node root = new Node(Integer.parseInt(br.readLine()));
        while(true) {
            str = br.readLine();
            if(str == null || str.length() == 0) break;
            int key = Integer.parseInt(str);
            root.insert(key);
        }

        postOrder(root);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void postOrder(Node parent) {
        if(parent == null) return;
        postOrder(parent.left);
        postOrder(parent.right);
        sb.append(parent.key+"\n");
    }
}