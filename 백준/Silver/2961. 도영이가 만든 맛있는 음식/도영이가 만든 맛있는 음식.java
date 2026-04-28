

import java.io.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;


public class Main {
	
	static int n;
	static int[] sour;
	static int[] bitter;
	static boolean[] visit;
	static int min_=Integer.MAX_VALUE;
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = Integer.parseInt(br.readLine());
    	visit = new boolean[n];
    	
    	sour = new int[n];
    	bitter= new int[n];
    	
    	
    	for(int i=0;i<n;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		sour[i] = Integer.parseInt(st.nextToken());
    		bitter[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	
    	for(int i=0;i<n;i++) {
    		combi(0,i+1);
    		visit = new boolean[n];
    	}
    	System.out.println(min_);
    	
    }
    
    public static void combi(int start, int r) {
    	if(r == 0) {
    		int sour1 = 1;
    		int bitter1 = 0;
    		
    		for(int i=0;i<n;i++) {
    			if(visit[i]) {
    				sour1 *=sour[i];
    				bitter1 += bitter[i];
    			}
    		}
    		min_ = Math.min(min_, Math.abs(sour1-bitter1));
    	}
    	
    	for(int i=start;i<n;i++) {
    		if(!visit[i]) {
    			visit[i] = true;
    			combi(i+1, r-1);
    			visit[i] = false;
    		}
    	}
    	
    }
    
    
}









