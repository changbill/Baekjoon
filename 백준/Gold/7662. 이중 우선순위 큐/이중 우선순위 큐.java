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
        
        TreeMap<Integer, Integer> treemap;
        
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
        	treemap = new TreeMap<>();
        	int N = Integer.parseInt(br.readLine());
        	for(int j = 0; j < N; j++) {
        		st = new StringTokenizer(br.readLine());
        		char cal = st.nextToken().charAt(0);
        		int num = Integer.parseInt(st.nextToken());
        		
        		if(cal == 'I') {
        			treemap.put(num, treemap.getOrDefault(num, 0)+1);  
        		} else if(cal == 'D' && !treemap.isEmpty()) {
        			if(num == -1) {
        				int min = treemap.firstKey();
        				int value = treemap.get(min);
        				if(value > 1) {					// 해당 숫자가 1보다 많다면
        					treemap.put(min, value-1);	// value -1
        				} else {
        					treemap.pollFirstEntry();	// 1이라면 treemap에서 빼준다
        				}
        			} else {
        				int max = treemap.lastKey();
        				int value = treemap.get(max);
        				if(value > 1) {					// 해당 숫자가 1보다 많다면
        					treemap.put(max, value-1);	// value -1
        				} else {
        					treemap.pollLastEntry();	// 1이라면 treemap에서 빼준다
        				}
        			}
        		}
        	}
        	if(treemap.isEmpty()) {
        		sb.append("EMPTY"+"\n");
        	} else {
        		sb.append(treemap.lastKey()+ " "+treemap.firstKey()+"\n");
        	}
        }
        
        System.out.println(sb.toString());
    }
}