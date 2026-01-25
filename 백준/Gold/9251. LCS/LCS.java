
import java.util.*;

public class Main {

    static String s1;
    static String s2;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        s1 = sc.next();
        s2 = sc.next();
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];



        for(int i=1;i<=n;i++){
            char c1 = s1.charAt(i-1);
            for(int j=1;j<=m;j++){
                char c2 = s2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] =dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }

        System.out.println(dp[n][m]);

    }



}