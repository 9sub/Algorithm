import java.util.*;

class Solution {
    static int[][] cnt;
    static int[] gift;
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        cnt = new int[friends.length][friends.length];
        gift = new int[friends.length];
        
        for(String s : gifts){
            String[] tmp_s = s.split(" ");
            
            for(int i=0;i<friends.length;i++){
                if(friends[i].equals(tmp_s[0])){
                    for(int j=0;j<friends.length;j++){
                        if(friends[j].equals(tmp_s[1])){
                            cnt[i][j] ++;
                        }
                    }
                }
            }
        }
        
        for(int i=0;i<cnt.length;i++){
            for(int j=i+1;j<cnt.length;j++){
                if(i==j) continue;
                int i_to_j = cnt[i][j];
                int j_to_i = cnt[j][i];
                if(i_to_j == j_to_i){
                    int i_gift_score = cal_gift(cnt, i);
                    int j_gift_score = cal_gift(cnt, j);
                    if(i_gift_score > j_gift_score) gift[i]++;
                    else if(i_gift_score<j_gift_score)gift[j]++;
                }
                else{
                    if(i_to_j>j_to_i) gift[i]++;
                    else gift[j]++;
                }
            }
        }
        int min_ = 0;
        for(int i=0;i<gift.length;i++){
            min_ = Math.max(min_, gift[i]);
        }
        return min_;
    }
    
    public static int cal_gift(int[][] cnt, int x){
        int to=0;
        int from=0;
        for(int i=0;i<cnt.length;i++){
            to += cnt[x][i];
        }
        for(int i=0;i<cnt.length;i++){
            from += cnt[i][x];
        }
        return to- from;
    }
    
}