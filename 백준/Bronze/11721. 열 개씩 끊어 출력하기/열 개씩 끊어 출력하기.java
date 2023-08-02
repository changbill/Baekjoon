
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언

        String word = br.readLine();
        char[] spell = new char[word.length()];
        String ten = "";
        for (int i = 0; i < word.length(); i++) {
            spell[i] = word.charAt(i);
        }

        for (int i = 0; i < word.length(); i++) {
            ten += spell[i];
            if (i % 10 == 9) {
                System.out.println(ten);
                ten = "";
            } else if (i == word.length()-1) {
                System.out.println(ten);
            }
        }



    }
}