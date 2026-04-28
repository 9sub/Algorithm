
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

	static int r,c,t;
	static int[][] arr;
	static int [] dx= {0,-1,0,1};
	static int [] dy= {-1,0,1,0};
	static int machine_i;
	static int machine_j;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		arr = new int[r][c];
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int tmp = find_machine();
		machine_i = tmp;
		machine_j = tmp+1;
		int cnt=0;
		while (cnt<t) {
			hwaksan();
			bingle();
			cnt++;
		}
		int cnt2=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[i][j] == -1) continue;
				cnt2+=arr[i][j]; 
			}
		}
		System.out.println(cnt2);
	}
	
	public static void hwaksan() {
		int[][] add = new int[r][c];
		int cnt=0;
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[i][j] == 0 || arr[i][j] == -1) continue;
				int tmp = arr[i][j] / 5;
				cnt=0;
				
				for(int d=0;d<4;d++) {
					int nx = dx[d]+j;
					int ny = dy[d]+i;
					if(nx<0 || nx>=c || ny<0 || ny>=r) continue;
					if(arr[ny][nx] == -1) continue;
					
					add[ny][nx] += tmp;
					cnt++;
				}
				arr[i][j] -= tmp*cnt;
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[i][j] == -1) continue;
				arr[i][j] += add[i][j];
			}
		}
		
	}
	
	public static int find_machine() {
		int tmp=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[i][j] == -1) {
					return i;
				}
			}
		}
		return 0;
	}
	
	public static void bingle() {
		// 위쪽
		int prev = 0;
		int up = machine_i;
		for(int j=1;j<c;j++) {
			int tmp = arr[up][j];
			arr[up][j] = prev;
			prev = tmp;
		}
		for(int i=up-1;i>=0;i--) {
			int tmp = arr[i][c-1];
			arr[i][c-1] = prev;
			prev = tmp;
		}
		for(int j=c-2;j>=0;j--) {
			int tmp = arr[0][j];
			arr[0][j] = prev;
			prev = tmp;
		}
		for(int i=1;i<up;i++) {
			int tmp = arr[i][0];
			arr[i][0] = prev;
			prev = tmp;
		}
		arr[up][0]=-1;
		
		
		//아래
		prev = 0;
		int down= machine_j;
		for(int j=1;j<c;j++) {
			int tmp = arr[down][j];
			arr[down][j] = prev;
			prev = tmp;
		}
		for(int i=down+1;i<r;i++) {
			int tmp = arr[i][c-1];
			arr[i][c-1] = prev;
			prev = tmp;
		}
		for(int j=c-2;j>=0;j--) {
			int tmp = arr[r-1][j];
			arr[r-1][j] = prev;
			prev = tmp;
		}
		for(int i=r-2;i>=down;i--) {
			int tmp = arr[i][0];
			arr[i][0] = prev;
			prev = tmp;
		}
		arr[down][0]=-1;
		
		
	}
	
	

}
