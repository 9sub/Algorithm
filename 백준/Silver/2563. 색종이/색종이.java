import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[101][101];
		for(int t=0;t<n;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++) {
					arr[y+i][x+j]= 1;
				}
			}
			
		}
		int cnt=0;
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(arr[i][j] == 1) cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
	
	
}
