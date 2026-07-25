
import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] arr;
    static int[] parent;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        arr = new ArrayList[n+1];
        for(int i=0;i<n;i++){
            arr[i] = new ArrayList<>();
        }
        
        parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
        
        for(int i=0;i<n;i++){
            int[] tmp = computers[i];
            for(int j=0;j<n;j++){
                if(i==j) continue;
                arr[i].add(computers[i][j]);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(computers[i][j] == 1){
                    union(i,j);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(i==parent[i]) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void union(int a,int  b){
        a = find(a);
        b = find(b);
        if(a!=b)parent[a] =b;
    }
    public static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    
}