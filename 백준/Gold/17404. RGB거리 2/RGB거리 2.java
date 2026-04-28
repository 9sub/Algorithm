import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] cost;
	static int[][] dp;


	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cost = new int[n+1][3];
		dp = new int[n+1][3];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// left
		
		dp[0][0] = cost[0][0];
		dp[0][1] = 9999999;
		dp[0][2] = 9999999;
		
		for(int i=1;i<n;i++) {
			dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}


		int min1 = Math.min(dp[n-1][1], dp[n-1][2]);
		// mid
		dp[0][1] = cost[0][1];
		dp[0][0] = 9999999;
		dp[0][2] = 9999999;
		
		for(int i=1;i<n;i++) {
			dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}

		
		int min2 =Math.min(dp[n-1][0], dp[n-1][2]);
		
		dp[0][2] = cost[0][2];
		dp[0][1] = 9999999;
		dp[0][0] = 9999999;
		
		for(int i=1;i<n;i++) {
			dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}

		
		int min3 =Math.min(dp[n-1][0], dp[n-1][1]);

		int real_min = Math.min(min1, Math.min(min2, min3));
		System.out.println(real_min);
		
	}

}
