import java.io.*;
import java.util.*;

public class Main {

    static class threePoint {
        int left, mid, right;

        public threePoint(int left, int mid, int right) {
            this.left = left;
            this.mid = mid;
            this.right = right;
        }
    }

    static int fst,sec,trd,maxfst,maxsec,maxtrd,minfst,minsec,mintrd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][3];
        int maxDp[][] = new int[N][3];
        int minDp[][] = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            int tmp = arr[0][i];
            minDp[0][i] = tmp;
            maxDp[0][i] = tmp;
        }

        for (int i = 1; i < N; i++) {
            fst = arr[i][0];
            sec = arr[i][1];
            trd = arr[i][2];
            maxfst = maxDp[i-1][0];
            maxsec = maxDp[i-1][1];
            maxtrd = maxDp[i-1][2];
            minfst = minDp[i-1][0];
            minsec = minDp[i-1][1];
            mintrd = minDp[i-1][2];
            maxDp[i][0] = fst + Math.max(maxfst,maxsec);
            minDp[i][0] = fst + Math.min(minfst,minsec);
            maxDp[i][2] = trd + Math.max(maxtrd,maxsec);
            minDp[i][2] = trd + Math.min(mintrd,minsec);
            maxDp[i][1] = sec + max(maxfst,maxsec,maxtrd);
            minDp[i][1] = sec + min(minfst,minsec,mintrd);
        }

        int maxAns = max(maxDp[N-1][0],maxDp[N-1][1],maxDp[N-1][2]);
        int minAns = min(minDp[N-1][0],minDp[N-1][1],minDp[N-1][2]);
        System.out.println(maxAns+" "+minAns);
    }

    public static int max(int one, int two, int thr) {
        int onetwo = Math.max(one,two);
        return Math.max(thr,onetwo);
    }

    public static int min(int one, int two, int thr) {
        int onetwo = Math.min(one,two);
        return Math.min(thr,onetwo);
    }
}