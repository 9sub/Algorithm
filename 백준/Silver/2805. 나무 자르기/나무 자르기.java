import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
	static int n;
	static long m;
	static int [] arr;

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		int max_=0;
		int min_=Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max_ = Math.max(arr[i], max_);
			min_ = Math.min(arr[i], min_);
		}
		int start =0;
		int end=max_;
		int tmp=0;
		int max=0;
		
		
		while(start <= end) {

			tmp=((start+end)/2);
			long sum=0;
			
			for(int i=0;i<n;i++) {
				if(arr[i]>tmp) sum+=(arr[i]-tmp);
			}	
			if(sum>=m) {
				max=tmp;
				start = tmp+1;
			}else {
				end = tmp-1;
			}
			
		}
		
		System.out.println(max);
		
	}
	



	
}
