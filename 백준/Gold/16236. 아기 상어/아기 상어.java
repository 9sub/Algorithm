import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

	static int n, start_i=0, start_j=0;
	static int[][] arr;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int size=2;
	static int visit[][];
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visit = new int[n][n];
		arr = new int[n][n];
		
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 9) {
					start_i=i;
					start_j=j;
					arr[i][j] =0 ;
				}
			}
		}
		
		int time=0, eat=0;
		while(true) {
			Result r = bfs(start_i, start_j, size);
			if(r==null) break;
			
			time+= r.dist;
			
			start_i = r.y;
			start_j = r.x;
			arr[start_i][start_j]=0;
			eat++;
			if(eat == size) {
				size++;
				eat = 0;
			}
			
			
		}
		
		System.out.println(time);

	}
	
	
	public static boolean is_empty() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j] != 0 && arr[i][j] !=9) return false;
			}
		}
		return true;
	}

	static class Result{
		int x,y,dist;
		Result(int y, int x, int dist){
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}
	
	
	public static Result bfs(int sy, int sx, int shark_size) {
		Deque<int[]> que = new ArrayDeque<>();
		int[][] dist = new int[n][n];
		for(int i=0;i<n;i++) Arrays.fill(dist[i], -1);
		
		que.add(new int[] {sy,sx});
		dist[sy][sx] = 0;
		
		int bestDist = Integer.MAX_VALUE;
		int bestY = -1, bestX = -1;
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int y = cur[0], x=cur[1];
			
			if(dist[y][x]>bestDist) continue;
			for(int d=0;d<4;d++) {
				int ny = y+dy[d];
				int nx = x+dx[d];
				
				if(ny<0 || ny>=n || nx<0 || nx>=n) continue;
				if(dist[ny][nx] != -1) continue;
				
				if(arr[ny][nx] > shark_size) continue; 
				
				dist[ny][nx] = dist[y][x]+1;
				que.add(new int[] {ny,nx});
				
				if(arr[ny][nx] !=0 && arr[ny][nx] < shark_size) {
					int canDist = dist[ny][nx];
					
					if(canDist < bestDist) {
						bestDist = canDist;
						bestY = ny;
						bestX = nx;
					}
					else if(canDist == bestDist) {
						if(ny<bestY || (ny==bestY && nx < bestX)) {
							bestY = ny;
							bestX = nx;
						}
					}
				}
				
			}

		}

		if(bestY == -1) return null;
		return new Result(bestY, bestX, bestDist);
				
		
	}
	
	
}
