import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,k;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        dp = new int[k+1];

        dp[0] = 0;
        for(int i=1;i<=k;i++)
            dp[i] = 100001;

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int coin : arr){
            for(int i=coin;i<k+1;i++){
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        if (dp[k] ==  100001)
            System.out.println("-1");
        else
            System.out.println(dp[k]);



    }



}


// 4, 2, 4, 4, 1