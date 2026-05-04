import java.util.*;

class Solution {
    static ArrayList<int[]> arr;
    static int[] select;
    
    public int[] solution(int[][] dice) {
        
        arr = new ArrayList<>();
        select = new int[dice.length/2];
        
        combi(0, 0, dice.length, dice.length/2);
        
        int maxwin = 0;
        int [] answer= new int[dice.length/2];
        
        for(int[] a : arr){
            int[] b = namuji(a, dice.length);
            
            ArrayList<Integer> alist = new ArrayList<>();
            ArrayList<Integer> blist = new ArrayList<>();
        
            makesum(0,a, dice, 0, alist);
            makesum(0,b, dice, 0, blist);
            
            Collections.sort(blist);
            
            int win=0;
            
            for(int asum : alist){
                win+= lower(blist, asum);
            }
            if(win>maxwin){
                maxwin=win;
                answer = a.clone();
            }
            
        }
        for(int i=0;i<answer.length;i++) answer[i]++;
        
        return answer;
    }
    
    public static int lower(ArrayList<Integer> list, int target){
        int left = 0;
        int right = list.size();
        
        
        while(left<right){
            int mid = (left+right)/2;
            
            if(list.get(mid) < target){
                left = mid+1;
            }else{
                right = mid;
            }
            
        }
        return left;
    }
    
    
    public static void makesum(int depth, int[] pick, int [][] dice, int sum, ArrayList<Integer> list){
        if(depth == pick.length){
            list.add(sum);
            return;
        }
        
        int ind = pick[depth];
        
        for(int i=0;i<6;i++){
            makesum(depth+1, pick, dice, sum+dice[ind][i], list);
        }
        
    }
    
    public static int[] namuji(int[] a, int n){
        int[] b = new int[n/2];
        int ind=0;
        for(int i=0;i<n;i++){
            if(!isIn(a, i)){
                b[ind++] = i;
            }
        }
        return b;
    }
    
    
    
    public static boolean isIn(int[] tmp, int x){
        for(int t : tmp){
            if(t == x) return true;
        }
        return false;
    }
    
    public static void combi(int start, int depth, int n, int r){
        if(depth == r){
            arr.add(select.clone());
            return;
        }
        
        for(int i=start; i<n;i++){
            select[depth] = i;
            combi(i+1, depth+1, n,r);
        }
        
    }
    
}