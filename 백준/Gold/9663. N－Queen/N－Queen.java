
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

	static int n,T;
	static int nums=0;
	static int[]cols;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		cols = new int[n+1];

		backTracking(0);
		
		System.out.println(nums);
		
	}
	
	public static void backTracking(int depth) {
		
		if(depth == n) {
			nums++;
			return;
   		}
		for(int i=0;i<n;i++) {
			cols[depth] = i;
			if(check(depth))
				backTracking(depth+1);
		}
	}
	
	public static boolean check(int col) {
		for(int j=0;j<col;j++) {
			if(cols[j] == cols[col])
				return false;
			else if(Math.abs(col-j) == Math.abs(cols[col]-cols[j])) return false;
		}
		return true;
	}

	
}
