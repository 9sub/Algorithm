import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int w,h;
	static int[][] arr;
	static int[] dx = {-1,0,1,-1,1,-1,0,1};
	static int[] dy = {-1,-1,-1,0,0,1,1,1};
	static boolean[][] visit;
	static int cnt=0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			cnt=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0) break;
			visit = new boolean[h][w];
			arr = new int[h][w];
			
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(!visit[i][j] && arr[i][j] == 1) {
						cnt+=1;
						dfs(j,i);
					}
				}
			}
			System.out.println(cnt);
		}
		
	}
	
	
	public static void dfs(int x, int y) {
		visit[y][x] = true;
		
		for(int i=0;i<8;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(check(nx,ny) && !visit[ny][nx] && arr[ny][nx] == 1) {
				dfs(nx,ny);
			}
		}
		
		
	}
	
	public static boolean check(int nx,int ny) {
		if(nx>=0 && nx<w && ny>=0 && ny <h)
			return true;
		else return false;
	}
	

}
