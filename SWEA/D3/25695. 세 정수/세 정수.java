import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
		for(int t = 1; t <= T; t++)
		{
			st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); // AB
            int Y = Integer.parseInt(st.nextToken()); // BC
            int Z = Integer.parseInt(st.nextToken()); // CA
            
            int A = -1, B = -1, C = -1;
            if(X == Y && Y == Z) {
                B = Y;
                A = C = B;
            }
                
           	if(X == Y && Y > Z) {
                B = Y;
                A = Z;
            }
                    
            if(Y == Z && Z > X) {
                C = Z;
                B = X;
            }
            
            if(X == Z && Z > Y) {
                A = Z;
                C = Y;
            }
            
            if(A != -1 || B != -1 || C != -1) {
                A = A == -1 ? 1 : A;
                B = B == -1 ? 1 : B;
                C = C == -1 ? 1 : C;
            }
            
            sb.append(A).append(' ').append(B).append(' ').append(C).append('\n');
		}
        System.out.println(sb.toString());
	}
}