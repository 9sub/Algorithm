import java.io.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;


public class Main {
	
	static int n;

    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	
    	int maxHLen = -1, maxWLen = -1;
        int maxHIdx = -1, maxWIdx = -1;
    	int[] length = new int[6];
    	
    	for(int i=0;i<6;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int where = Integer.parseInt(st.nextToken());
    		length[i]= Integer.parseInt(st.nextToken());
    		
    		if (where == 1 || where == 2) {
                if (length[i] > maxWLen) {
                    maxWLen = length[i];
                    maxWIdx = i;
                }
            }
            else {
                if (length[i] > maxHLen) {
                    maxHLen = length[i];
                    maxHIdx = i;
                }
            }
    	}
    	
    	int leftOfH = (maxHIdx - 1 + 6) % 6;
        int rightOfH = (maxHIdx + 1) % 6;
        int smallW = Math.abs(length[leftOfH] - length[rightOfH]);

        int leftOfW = (maxWIdx - 1 + 6) % 6;
        int rightOfW = (maxWIdx + 1) % 6;
        int smallH = Math.abs(length[leftOfW] - length[rightOfW]);

        int bigArea = maxWLen * maxHLen;
        int smallArea = smallW * smallH;

        System.out.println(n * (bigArea - smallArea));
    	
    	
    	
    }
}









