import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, arr[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visit = new boolean[N+1];
		dfs(0,0);
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int num, int depth) {
		if(depth == M) {
			for(int i = 0; i<M; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = num+1; i<=N; i++) {
			if(!visit[i]) {
				arr[depth] = i;
				visit[i] = true;
				dfs(i,depth+1);
				visit[i] = false;
			}
		}

	}
}
