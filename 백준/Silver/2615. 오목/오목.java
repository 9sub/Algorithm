
import java.util.*;




public class Main {
	static int[][] arr;
	static int n=19;
	static int[] dx = {1,0,1, 1};
	static int[] dy = {0,1,1,-1};
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();			
			}
		}

		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j] == 0) continue;
				
				int color = arr[i][j];
				
				for(int l=0;l<4;l++) {
					
					int px =j-dx[l];
					int py =i-dy[l];
					if ((px >= 0 && px < n && py >= 0 && py < n) && arr[py][px] == color) continue;
					
					int cnt = 1;
					
					int nx = j+dx[l];
					int ny = i+dy[l];
					while((nx>=0 && nx<n && ny>=0 && ny<n) && arr[ny][nx] == color) {
						cnt+=1;
						nx += dx[l];
						ny += dy[l];
					}
					if(cnt == 5) {
						if ((nx>=0 && nx<n && ny>=0 && ny<n) && arr[ny][nx] == color) continue;
						
						System.out.println(color);
						System.out.println((i+1)+" "+(j+1));
						return;
					}
					
					
				}
				
			}
		}
		System.out.println(0);
		
	}
	
}
