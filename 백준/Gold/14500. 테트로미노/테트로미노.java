import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

	static int n,m;
	static int [][] arr;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] visit;
	static int sum_=0;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				visit[i][j] = true;
				dfs(i,j,0,arr[i][j]);
				visit[i][j] = false;
			}
		}
		System.out.println(sum_);
		
	}
	
	public static void dfs(int i, int j,int depth, int sum) {
		
		if(depth == 3) {
			sum_ = Math.max(sum_, sum);
			return;
		}

		for(int d=0;d<4;d++) {
			int nx = j+dx[d];
			int ny = i+dy[d];
			if(nx<0 || nx>=m||ny<0 || ny>=n) continue;
			if(visit[ny][nx]) continue;
			
			if(depth==1) {
				visit[ny][nx] = true;
				dfs(i,j,depth+1, sum+arr[ny][nx]);
				visit[ny][nx] = false;
			}
			
			visit[ny][nx] = true;
			dfs(ny,nx, depth+1, sum+arr[ny][nx]);
			visit[ny][nx] = false;
		}
		
		
	}


	
}
