import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
     
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Boolean> treemap = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	String str = st.nextToken();
        	if(!treemap.containsKey(str) && st.nextToken().equals("enter")) {
        		treemap.put(str, true);
        	} else {
        		treemap.remove(str);
        	}
        }
        
        while(!treemap.isEmpty()) {
        	sb.append(treemap.pollFirstEntry().getKey()+"\n");
        }
        
        System.out.println(sb.toString());
    }
}