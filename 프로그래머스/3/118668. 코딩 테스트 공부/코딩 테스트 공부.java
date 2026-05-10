import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        
        int max_alp=0;
        int max_cop = 0;
        
        for(int[] pro:problems){
            max_alp = Math.max(max_alp, pro[0]);
            max_cop = Math.max(max_cop, pro[1]);
        }
        
        int[][] dp = new int[max_alp+1][max_cop+1]; // 알고력, 코딩력 dp
        
        for(int i=0;i<=max_alp;i++){
            Arrays.fill(dp[i], 1_000_000_000);
        }
        
        alp = Math.min(max_alp, alp);
        cop = Math.min(max_cop, cop);
        
        dp[alp][cop] = 0;
            
        for(int i = alp;i<=max_alp;i++){
            for(int j=cop;j<=max_cop;j++){
                if(i+1<=max_alp){ //알고 공부
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                }
                
                if(j+1<=max_cop){ //코딩 공부
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                }
                
                for(int[] pro:problems){
                    int alp_req = pro[0];//필요한 알고력
                    int cop_req = pro[1];// 필요한 코딩력
                    int alp_rwd = pro[2];//증가 알고력
                    int cop_rwd = pro[3];//증가 코딩력
                    int cost = pro[4];//시간
                    
                    if(i>=alp_req && j>=cop_req){
                        int next_alp = Math.min(max_alp, i+alp_rwd);
                        int next_cop = Math.min(max_cop, j+cop_rwd);
                        dp[next_alp][next_cop] = Math.min(dp[next_alp][next_cop], dp[i][j]+cost);
                    }
                    
                    
                }
                
            }
        }
        
        
        return dp[max_alp][max_cop];
    }
}