import java.util.*;

class Solution {
    
    static int[] discount = {10,20,30,40};
    static int[] select;
    static int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        select = new int[emoticons.length];
        dfs(users, emoticons, 0);
        
        return answer;
    }
    
    public void dfs(int[][] users, int[] emoticons, int depth){
        
        if(depth == emoticons.length){
            cal(users, emoticons);
            return;
        }
        
        for(int disc : discount){
            select[depth] = disc;
            //System.out.println(Arrays.toString(select));
            dfs(users, emoticons, depth+1);
        }
    }
    public void cal(int[][] users, int[] emoticons){
        
        int subs = 0;
        int buy=0;
        
        for(int[] user:users){
            int dis = user[0];
            int price = user[1];
            
            int sum=0;
            
            for(int i=0;i<emoticons.length;i++){
                if(select[i] >= dis){
                   sum += emoticons[i] * (100 - select[i])/100; 
                }
            }
            
            if(sum>= price) subs++;
            else buy+=sum;
            
        }
        
        if(subs > answer[0]){
            answer[0] = subs;
            answer[1] = buy;
        }else if(subs == answer[0] && buy > answer[1]){
            answer[1] = buy;
        }
        
    }
    
}