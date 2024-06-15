import java.io.*;
import java.util.*;

class Main {
	static int[] NArr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		if(K == 1) {
			System.out.println(0);
			return;
		} else if(K == 2) {
			System.out.println(1);
			return;
		}
		
		NArr = new int[K+1];
		NArr[1] = 0;
		NArr[2] = 1;

		for(int n = 3; n <= K; n++) {
			NArr[n] = (NArr[n-1] + NArr[n-2])%1_000_000_007;
		}
		
		System.out.println(NArr[K]);
	}
}