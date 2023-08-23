import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean[] LArr = new boolean[L+1]; // 케익 유무

        int expectMax = 0;
        int expectIdx = 0;
        int realMax = 0;
        int realIdx = 0;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());


            if(expectMax < end-start+1) {
                expectMax = end - start +1;
                expectIdx = i;
            }

            int cnt = 0;
            int j = start;
            while(j<=end && j>=start) {
                if(LArr[j]) {
                    j++;
                    continue;
                }
                LArr[j] = true;
                cnt++;
                j++;
            }
            if(realMax < cnt) {
                realMax = cnt;
                realIdx = i;
            }
        }

        System.out.println(expectIdx);
        System.out.println(realIdx);
    }
}