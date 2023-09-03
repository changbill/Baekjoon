import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        boolean[] Arr = new boolean[21];
        int M = Integer.parseInt(br.readLine());
        for (int t = 0; t < M; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str) {
                case "add":
                    Arr[Integer.parseInt(st.nextToken())] = true;
                    break;
                case "remove":
                    Arr[Integer.parseInt(st.nextToken())] = false;
                    break;
                case "check":
                    if(Arr[Integer.parseInt(st.nextToken())]) {
                        sb.append(1+"\n");
                    } else {
                        sb.append(0+"\n");
                    }
                    break;
                case "toggle":
                    int tmp = Integer.parseInt(st.nextToken());
                    if(Arr[tmp]) {
                        Arr[tmp] = false;
                    } else {
                        Arr[tmp] = true;
                    }
                    break;
                case "all":
                    for (int i = 1; i < 21; i++) {
                        Arr[i] = true;
                    }
                    break;
                case "empty":
                    for (int i = 1; i < 21; i++) {
                        Arr[i] = false;
                    }
                    break;
            }
        }


        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}