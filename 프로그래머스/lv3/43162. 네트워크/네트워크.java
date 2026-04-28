import java.util.*;

class Solution {
    
    static boolean[] visit;
    static int[] parent;
    static int[] rank;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i != j && computers[i][j] == 1)
                    union(i,j);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(find(i));
        }
        System.out.println(set.toString());
    
        return set.size();
        
    }
    
    public int find(int x){
        if(x == parent[x])
            return x;
        return parent[x]= find(parent[x]);
    }
    
    public void union(int x, int y){
        
        int parent_x = find(x);
        int parent_y = find(y);
        
        if(rank[parent_x] > rank[parent_y]){
            parent[parent_y] = parent_x;
        }else if(rank[parent_x]<rank[parent_y])
            parent[parent_x] = parent_y;
        else{
            parent[parent_x] = parent_y;
            rank[parent_y]++;
        }
        
    }
        
    
}