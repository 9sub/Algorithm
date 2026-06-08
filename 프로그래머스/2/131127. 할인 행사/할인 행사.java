import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        //10일동안
        for(int i=0;i<=discount.length - 10;i++){
            int[] cnt = new int[want.length];
            
            for(int j=i;j<i+10;j++){
                String name = discount[j];
                
                for(int k=0;k<want.length;k++){
                    if(want[k].equals(name)){
                        cnt[k]++;
                        break;
                    }
                }
                
            }
            
            int flag = 0;
            
            // System.out.println(Arrays.toString(cnt));
            
            for(int j=0;j<want.length;j++){
                if(cnt[j] != number[j]){
                    flag = 1;
                    break;
                }
            }
            
            if(flag == 0) answer++;
            
        }
        
        return answer;
    }
}