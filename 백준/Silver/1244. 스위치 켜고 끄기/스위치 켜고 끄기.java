import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] Arr;
    public static void switchon(int swNum) {
        if(Arr[swNum] == 0) {
            Arr[swNum] = 1;
        } else {
            Arr[swNum] = 0;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int Switch = Integer.parseInt(br.readLine());
        Arr = new int[Switch+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=Switch; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        int sNum = Integer.parseInt(br.readLine());
        for(int i =0; i<sNum; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int swNum = Integer.parseInt(st.nextToken());

            if(sex == 1) {
                for (int j = 1; swNum*j <= Switch; j++) {
                        switchon(swNum*j);
                }

            } else {
                switchon(swNum);
                for (int j = 1; j <= Switch/2; j++) {
                    if(swNum-j>0 && swNum+j<=Switch && Arr[swNum+j] == Arr[swNum-j]) {
                        switchon(swNum+j);
                        switchon(swNum-j);
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 1; i < Arr.length; i++) {
            sb.append(Arr[i]);
            if(i == Arr.length-1) break;
            if(i%20!=0){
                sb.append(" ");
            } else {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}