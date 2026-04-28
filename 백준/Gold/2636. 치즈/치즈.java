import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int a,b;
	static int[][] arr;
	static boolean[][] visit;
	static boolean[][] melt;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		arr = new int[a+2][b+2];
		visit = new boolean[a+2][b+2];
		melt = new boolean[a+2][b+2];
		
		for(int i=1;i<=a;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=b;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt=0;
		int last =  0;
		
		while(true) {
			int tmp = cheese_count();
			if(tmp == 0)	break;
			last = tmp;
			bfs();
			if(!melt_one_layer()) break;

			cnt++;
		}
		System.out.println(cnt);
		System.out.println(last);

		
	}
	
	public static int cheese_count() {
		int cnt=0;
		for(int i=1;i<=a;i++) {
			for(int j=1;j<=b;j++) {
				if(arr[i][j] == 1) cnt++;
			}
		}
		return cnt;
	}
	
	public static boolean melt_one_layer() {
		for(int i=0;i<=a+1;i++) Arrays.fill(melt[i], false);
		boolean is_melt = false;
		for(int i=1;i<=a;i++) {
			for(int j=1;j<=b;j++) {
				if(arr[i][j] == 1) {
					for(int d=0;d<4;d++) {
						int nx = j+dx[d];
						int ny = i+dy[d];
						if(nx<0 || nx >=b+2 || ny<0 || ny>=a+2) continue;
						
						if(arr[ny][nx] == 2) {
							melt[i][j] = true;
							break;
						}
					}
				}
			}
		}
		
		for(int i=1;i<=a;i++) {
			for(int j=1;j<=b;j++) {
				if(melt[i][j]) {
					arr[i][j] = 0;
					is_melt = true;
				}
			}
		}
		return is_melt;
		
	}
	
	public static void bfs() {
	
		for(int i=0;i<=a+1;i++) Arrays.fill(visit[i], false);
		
		Queue<int[]> que = new ArrayDeque<>();
		visit[0][0] = true;
		arr[0][0] = 2;
		que.add(new int[]{0,0});
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int y=cur[0], x=cur[1];
			
			for(int d=0;d<4;d++) {
				int ny = y+dy[d];
				int nx = x+dx[d];
				
				if(ny<0 || ny>=a+2 || nx<0 || nx>=b+2)continue;
				if(visit[ny][nx]) continue;
				if(arr[ny][nx] != 1) {
					visit[ny][nx] = true;
					arr[ny][nx] = 2;
					que.add(new int[] {ny,nx});
				}
			}
		}
		
		
	}
	
	
}
