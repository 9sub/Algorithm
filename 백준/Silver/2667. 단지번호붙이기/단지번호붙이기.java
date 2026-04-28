import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] arr;
	static boolean[][] visit;
	static int cnt=0;
	static int cnt2=0;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new boolean[n][n];
		ArrayList<Integer> house = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				cnt2=1;
				if(!visit[i][j] && arr[i][j] == 1) {
					cnt+=1;
					dfs(i,j);
					house.add(cnt2);
//					System.out.println(cnt2);
				}
			}
		}
		Collections.sort(house);
		System.out.println(cnt);
		for(int i=0;i< cnt;i++) {
			System.out.println(house.get(i));
		}
		
	}
	
	public static void dfs(int i, int j) {
		visit[i][j]=true;
		for(int d=0;d<4;d++) {
			int nx = j+dx[d];
			int ny = i+dy[d];
			if(nx>=0 && nx<n && ny>=0 && ny<n) {
				if(!visit[ny][nx] && arr[ny][nx] == 1) {
					visit[ny][nx] = true;
					cnt2++;
					dfs(ny, nx);
				}
			}
		}
	}

	
	
}
