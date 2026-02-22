import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String a,b,c;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        a =  br.readLine();
        b =  br.readLine();
        c =  br.readLine();

        int a_len = a.length()+1;
        int b_len = b.length()+1;
        int c_len = c.length()+1;

        dp = new int[a_len][b_len][c_len];


        for(int i=1;i<a_len;i++) {
            char c1 = a.charAt(i-1);
            for(int j=1;j<b_len;j++) {
                char c2 = b.charAt(j-1);
                for(int k=1;k<c_len;k++) {
                    char  c3 = c.charAt(k-1);
                    if(c1 == c2 && c2 == c3) {
                        dp[i][j][k] = dp[i-1][j-1][k-1]+1;
                    }else{
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }

            }
        }
        System.out.println(dp[a_len-1][b_len-1][c_len-1]);

    }



}


// 4, 2, 4, 4, 1