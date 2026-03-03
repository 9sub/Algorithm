import java.io.*;
import java.util.*;

public class Main {
    static String ss;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ss = br.readLine();
        int n = ss.length();

        char[] s = new char[n+1];
        for(int i=1;i<=n;i++) {
            s[i]=ss.charAt(i-1);
        }

        boolean[][] flag = new boolean[n+1][n+1];
        //한글자
        for(int i=1;i<=n;i++) flag[i][i] = true;
        //2글자
        for(int i=1;i<n;i++) if(s[i] == s[i+1]) flag[i][i+1] = true;
        //3글자 이상, 양끝이 같고 안쪽이 팰린드롬
        for(int len=3;len<=n;len++){
            for(int i=1;i+len-1<=n;i++){
                int j = i+len-1;
                if(s[i] == s[j] && flag[i+1][j-1])    flag[i][j] = true; //양끝 빼고 안쪽 팰린인지
            }
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                if(flag[j][i]) dp[i] = Math.min(dp[i], dp[j-1]+1);
            }
        }
        System.out.println(dp[n]);
    }



}