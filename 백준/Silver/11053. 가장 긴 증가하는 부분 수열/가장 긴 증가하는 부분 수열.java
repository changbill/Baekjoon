import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int dp[] = new int[N+1]; // 최대값 저장
		dp[0] = 0;
		for(int i = 1; i<=N; i++) {
			int max = 0;
			int idx = 0;
			for(int j = i-1; j>=0; j--) {
				if(arr[j] <arr[i] && max < dp[j]) { // 증가하는 수이고, 
					max = dp[j];
					idx = j;
				}
			}
			dp[i] = dp[idx] + 1;
		}
		
		int max = 0;
		for(int i = 1; i<=N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		bw.write(Integer.toString(max));
		bw.flush();
		bw.close();
		br.close();
	}
}