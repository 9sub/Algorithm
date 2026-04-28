import java.util.*;


public class Main {

	static int print_i;
	static int print_j;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int t = sc.nextInt();
		
		makeDalPangi(n,t);
		System.out.println((print_i+1)+" "+ (print_j+1));
	}
	
	public static void makeDalPangi(int n, int t) {
		int cnt=1;
		int length =1;
		int length_ind =0;
		int[][] arr = new int[n][n];
		
		
		int[] dx = {0,1,0,-1};
		int[] dy = {-1,0,1,0};
		
		int start_i = n/2;
		int start_j = n/2;
		int tmp=0;
		
		while (cnt<=n*n) {
			
			for(int i=0;i<length;i++) {
				if(cnt == t){
					print_i = start_i;
					print_j = start_j;
				}
				arr[start_i][start_j] = cnt++;
				
				start_j = start_j + dx[length_ind];
				start_i = start_i + dy[length_ind];
			}
			
			tmp++;
			length_ind++;
			if(length_ind == 4)
				length_ind=0;
			if(tmp == 2) {
				tmp=0;
				length++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<n;i++){
		  for (int j=0;j<n;j++){
		    sb.append(arr[i][j]).append(' ');
		  }
		  sb.append('\n');
		}
		System.out.print(sb);
		
		
	}
	

}
