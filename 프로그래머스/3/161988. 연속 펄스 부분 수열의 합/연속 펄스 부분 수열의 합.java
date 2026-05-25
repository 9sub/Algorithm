import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        int size=sequence.length;
        
        long[] arr1 = new long[size]; // [-1 1 -1 1]
        long[] arr2 = new long[size]; // [1 -1 1 -1]
        for(int i=0;i<size;i++){
            if(i%2 == 0) {
                arr1[i] = -sequence[i];
                arr2[i] = sequence[i];
            }
            else {
                arr1[i] = sequence[i];
                arr2[i] = -sequence[i];
            }
        }
        
        
        long total = 0;
        
        for(int left=0, right=0; left<size;left++){
            while(right<size && total>=0){
                total += arr1[right];
                answer = Math.max(total, answer);
                right++;
            }
            total -= arr1[left];
        }
        
        for(int left=0, right=0; left<size;left++){
            while(total>=0 && right<size){
                total += arr2[right];
                answer = Math.max(total, answer);
                right++;
            }
            total -= arr2[left];
        }
        
        return answer;
    }
}