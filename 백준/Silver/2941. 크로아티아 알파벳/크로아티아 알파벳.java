import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        String str = br.readLine();
        int lnth = str.length();
        int cnt = 0;
        
        for(int i = 0; i<lnth-1; i++) {
        	switch(str.substring(i, i+2)) {
        	case "c=": case "c-": case "d-": case "lj": case "nj": case "s=": case "z=":
        		cnt++;
        		break;
        	}
        	if(i>0) {
	        	if (str.substring(i-1, i+2).equals("dz=")) {
	        		cnt++;
	        	}
        	}
        }
        System.out.println(lnth-cnt);
    }
}