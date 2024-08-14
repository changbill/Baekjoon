import java.io.*;
import java.util.*;

public class Main {

    static int N, preOrderIdx;
    static int[] inOrder, postOrder, preOrder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        inOrder = new int[N+1];   // 중위 순회 : left -> root -> right
        postOrder = new int[N+1]; // 후위 순회 : left -> right -> root
        preOrder = new int[N+1];  // 전위 순회 : root -> left -> right

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        preOrderIdx = 1;
        searchPreOrder(1, N, 1, N);

        for(int i = 1; i <= N; i++) {
            sb.append(preOrder[i] + " ");
        }
        System.out.println(sb);
    }

    static void searchPreOrder(int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd) {
        if(inOrderStart <= inOrderEnd && postOrderStart <= postOrderEnd) {
            preOrder[preOrderIdx++] = postOrder[postOrderEnd];

            int inOrderParentIdx = inOrderStart;
            for(int i = inOrderStart; i <= inOrderEnd; i++) {
                if(postOrder[postOrderEnd] == inOrder[i]) {
                    inOrderParentIdx = i;
                    break;
                }
            }

            // left
            searchPreOrder(inOrderStart, inOrderParentIdx-1, postOrderStart, postOrderStart + inOrderParentIdx - inOrderStart - 1);
            // right
            searchPreOrder(inOrderParentIdx+1, inOrderEnd, postOrderEnd-inOrderEnd+inOrderParentIdx, postOrderEnd-1);
        }
    }
}