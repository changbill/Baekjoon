
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int N, C, house[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 집 개수
        C = Integer.parseInt(st.nextToken()); // 공유기 개수
        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }   // 집 위치 입력 완

        Arrays.sort(house);

        int low = 1;
        int high = house[N-1] - house[0]+1;
        while(low < high) {
            int mid = (low + high)/2;

            if(install(mid) < C) { // 설치 가능한 공유기 개수가 C보다 작다면
                high = mid;        // 설치 가능한 공유기 개수가 증가하도록 거리를 좀더 좁힌다
            } else {               // 설치 가능한 공유기 개수가 C보다 크다면
                low = mid + 1;     // 거리를 좀 더 벌린다
            }
        }

        System.out.println(low - 1);
    }

    public static int install(int distance) {
        int lastloc = house[0];
        int wifi = 1;

        for (int i = 1; i < N; i++) {
            int locate = house[i];

            if(locate - lastloc >= distance) {
                wifi++;
                lastloc = locate;
            }
        }

        return wifi;
    }
}
