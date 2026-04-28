import java.util.*;

class Solution {
    
    static ArrayList<String> arr;
    static boolean[] visit;
    
    public String[] solution(String[][] tickets) {
        
        arr = new ArrayList<>();
        visit = new boolean[tickets.length+1];
        
        Arrays.sort(tickets, (a,b)->{
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        arr.add("ICN");
        dfs("ICN", tickets, 0);
        
        String[] answer = new String[arr.size()];
        
        for(int i=0;i<arr.size();i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
    
    public boolean dfs(String start, String[][] tickets, int cnt){
        
        if(cnt == tickets.length){
            return true;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(!visit[i] && start.equals(tickets[i][0])){
                visit[i] = true;
                arr.add(tickets[i][1]);
                
                if(dfs(tickets[i][1], tickets, cnt+1)) return true;
                
                visit[i] = false;
                arr.remove(arr.size() - 1);
            }
        }
        return false;
        
    }
    
}