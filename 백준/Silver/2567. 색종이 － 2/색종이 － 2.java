
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

	static int n;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr =new int[101][101];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			fill(x,y);
		}


		int cnt1=0;
		int cnt2=0;
		
		for(int i=1;i<100;i++) {
			for(int j=0;j<100;j++) {
				if((arr[i][j] == 1 && arr[i][j-1] == 0) || (arr[i][j] ==1 && arr[i][j+1] == 0))
					cnt1++;
				if((arr[i][j] == 1 && arr[i-1][j] == 0) || (arr[i][j] == 1 && arr[i+1][j] == 0))
					cnt2++;
			}
		}
		System.out.println(cnt1+cnt2);
	}
	
	public static void fill(int x, int y) {
		
		for(int i=y;i<y+10;i++) {
			for(int j=x;j<x+10;j++) {
				arr[i][j] = 1;
			}
		}
		
	}
	
	


}
