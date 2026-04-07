import java.util.*;

class Solution {
    
    static class Node{
        String word;
        int depth;
        Node(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
    
    static int n;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        n = words.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(target.equals(words[i])) cnt++;
        }
        if(cnt == 0) return 0;
        
        return bfs(begin, target, words);
    }
    
    public int bfs(String begin, String target, String[] words){
        Queue<Node> que = new LinkedList<>();
        
        que.add(new Node(begin , 0));
        
        while(!que.isEmpty()){
            
            Node cur = que.poll();
            if(target.equals(cur.word)) return cur.depth;
            
            for(String s : words){
                if(is_change(cur.word, s)){
                    que.add(new Node(s, cur.depth+1));
                }
            }
            
        }
        return 0;
        
    }
    
    public static boolean is_change(String begin, String target){
        int cnt=0;
        for(int i=0;i<begin.length();i++){
            if(begin.charAt(i) !=  target.charAt(i)) cnt++;
        }
        
        return cnt == 1 ? true : false;
    }
    
}