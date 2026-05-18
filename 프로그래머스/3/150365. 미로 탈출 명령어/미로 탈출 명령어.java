class Solution {
    
    static boolean flag=false;
    static String answer = "";
    static int[] dy = {0,-1,1,0};
    static int[] dx = {1,0,0,-1};
    static String[] command = new String[]{"d","l","r","u"};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        int remain = k-Math.abs(x-r)+Math.abs(y-c);
        
        if(remain<0 || remain%2!=0) return "impossible";
        
        dfs(n,m,x,y,r,c,k,0,"");
        if(answer.equals("")) return "impossible";
        return answer;
        
        
    }
    
    public void dfs(int n, int m, int x, int y, int r, int c, int k, int dist, String path){
        if(flag || Math.abs(x-r)+Math.abs(y-c) + dist>k)
            return;
        if(dist == k && x == r && y == c){
            flag = true;
            answer += path;
            return;
        }
        
        for(int i=0;i<4;i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            
            if(nx<=n && nx>0 && ny>0 && ny<=m){
                dfs(n,m,nx,ny,r,c,k,dist+1, path+command[i]);
            }
            
        }        
    }
    
}