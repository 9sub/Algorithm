class Solution {
    
    static boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visit = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visit[i]){
                answer++;
                dfs(computers, i);
            }
        }
        
        return answer;
    }
    
    public void dfs(int[][] arr, int x){
        visit[x] = true;
        
        for(int i=0;i<arr.length;i++){
            if(!visit[i] && arr[x][i] == 1){
                dfs(arr, i);
            }
        }
        
    }
    
}