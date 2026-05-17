import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int [] answer = new int[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            String bin = Long.toBinaryString(numbers[i]);
            // System.out.println(bin);
            int len=1;
            while(len < bin.length()){ // 1 3 7 15
                len = len*2+1;
            }
            
            StringBuilder sb = new StringBuilder();
            
            for(int j=0;j<len - bin.length();j++){ // 부족한만큼 0 추가
                sb.append('0');
            }
            sb.append(bin);
            
            String tree = sb.toString();
            
            if(check(tree, 0, tree.length()-1)){
                answer[i] = 1;
            }else answer[i] = 0;
            
        }
        
        return answer;
        
    }
    
    
    public boolean check(String tree, int start, int end){
        if(start == end) return true;
        
        int mid = (start+end)/2;
        
        int left = (start+mid-1)/2;
        int right = (mid+1+end)/2;
        
        if(tree.charAt(mid) == '0'){
            if(tree.charAt(left) == '1' || tree.charAt(right) == '1'){
                return false;
            }
        }
        return check(tree, start, mid-1) && check(tree, mid+1, end);
        
    }
}