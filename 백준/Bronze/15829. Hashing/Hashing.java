import java.io.*;

public class Main {
    static long M = 1234567891;
    static int r = 31;

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char arr[] = str.toCharArray();
        long ans = 0;
        long pow = 1;
        for(int i = 0; i < L; i++) {
            long charVal = arr[i] - 'a' + 1;
            ans = (ans + charVal * pow) % M;
            pow = (pow * r) % M;
        }

        System.out.println(ans);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}