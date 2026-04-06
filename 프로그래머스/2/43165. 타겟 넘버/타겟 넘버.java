import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        int ind;
        int sum;
        
        Node(int ind, int sum){
            this.ind = ind;
            this.sum = sum;
        }
        
        @Override
        public int compareTo(Node o){
            return o.sum - this.sum;
        }
    }
    
    public int solution(int[] numbers, int target) {
        
        
        return bfs(numbers, target);
    }
    
    public static int bfs(int[] numbers, int target){
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(0,0));
        int answer = 0;
        while(!que.isEmpty()){
            Node cur = que.poll();
            
            if(cur.ind == numbers.length){
                if(cur.sum == target){
                    answer++;
                }
            }else{
                que.add(new Node(cur.ind+1, cur.sum + numbers[cur.ind]));
                que.add(new Node(cur.ind+1, cur.sum - numbers[cur.ind] ));
            }
            
        }
        return answer;
        
    }
}