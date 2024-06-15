import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for(int i = 7; i >= 0; i--) {
			ans += sum/(int) Math.pow(8,i) * (int) Math.pow(10,i);
			sum = sum % (int) Math.pow(8,i);
		}
		
		System.out.println(ans);
	}
}