import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int r;
	static int c;
	
	static int[] dx = {1,1,1};
	static int[] dy = {-1,0,1};
	static char[][] arr;
	static int[][] visit;
	static int[][] maps;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		visit = new int[r][c];
		maps = new int[r][c];
		
		for(int i=0;i<r;i++) {
			String line = bf.readLine();
			for(int j=0;j<c;j++) {
				arr[i][j] = line.charAt(j);
				if(arr[i][j] == '.')
					maps[i][j] = 0;
				else
					maps[i][j] = 1;
			}
		}
		int max=0;
		for(int i=0;i<r;i++) {
			if(maps[i][0] == 0) {
				if(gas(i,0))
					max++;
			}
		}
		System.out.println(max);
//		for(int i=0;i<r;i++) {
//			for(int j=0;j<c;j++)
//				System.out.print(maps[i][j]);
//			System.out.println();
//		}
		
	}
	
	public static boolean gas(int i, int j) {
		for(int d=0; d<3;d++) {
			int nx = j + dx[d];
			int ny = i + dy[d];
			
			if(!check(ny, nx)) continue;
			if(maps[ny][nx] == 0) {
				if(nx == c-1)
					return true;
				maps[ny][nx] = 2;
				if(gas(ny,nx)) return true;
			}
			
		}
		return false;
	}
	
	public static boolean check(int i, int j) {
		return i>=0 && i<r && j>=0 && j<c;
	}
	
	
}
