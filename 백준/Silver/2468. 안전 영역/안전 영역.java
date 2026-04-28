
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

	static int n;
	static int[][] arr;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] visit;
	static int cnt=0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int [n][n];
		
		int max=0;
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>max) max=arr[i][j];
			}
		}
		
		int max2=0;
		for(int t=0;t<max;t++) {
			visit = new boolean [n][n];
			cnt=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j]>t && !visit[i][j]) {
						cnt+=dfs(i,j,t);
					}
				}
			}
			max2=Math.max(max2, cnt);
		}
		
		System.out.println(max2);
	}
	
	public static int dfs(int i, int j, int how) {
		visit[i][j] = true;
		
		for(int d = 0;d<4;d++) {
			int nx = j+dx[d];
			int ny = i+dy[d];
			
			if(nx<0||nx>=n||ny<0||ny>=n) continue;
			
			if(!visit[ny][nx] && how<arr[ny][nx]) {
				dfs(ny,nx,how);
			}
		}
		
		return 1;
	}
	
	

}
