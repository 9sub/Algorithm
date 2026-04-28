import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,s;
	static int[] arr;
	static int a=0,b=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int min_=Integer.MAX_VALUE;
		int sum=0, cnt=0;
		while(true) {
			
			if(sum>=s) {
				
				min_ = Math.min(min_, b-a);
				sum -= arr[a++];
				cnt++;
			}else {
				if(b == n) break;
				sum+=arr[b++];
			}
			
		}
		if(cnt == 0) System.out.println(0);
		else System.out.println(min_);
		
	}
	

	
}
