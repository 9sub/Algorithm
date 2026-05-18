import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] tree;
    static int[] idx;
    
    public int[] solution(int[][] edges, int[] target) {
        int n = target.length;
        
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            tree[parent].add(child);
        }
        
        for (int i = 1; i <= n; i++) {
            Collections.sort(tree[i]);
        }
        
        idx = new int[n + 1];
        int[] count = new int[n + 1];
        ArrayList<Integer> order = new ArrayList<>();
        
        while (true) {
            int leaf = drop(1);
            order.add(leaf);
            count[leaf]++;
            
            boolean possible = true;
            boolean complete = true;
            
            for (int i = 1; i <= n; i++) {
                if (target[i - 1] == 0) continue;
                
                if (count[i] > target[i - 1]) {
                    return new int[]{-1};
                }
                
                if (count[i] > target[i - 1] || count[i] * 3 < target[i - 1]) {
                    complete = false;
                }
                
                if (count[i] > target[i - 1]) {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) {
                return new int[]{-1};
            }
            
            if (complete) {
                break;
            }
        }
        
        int[] remainCnt = count.clone();
        int[] remainTarget = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            remainTarget[i] = target[i - 1];
        }
        
        int[] answer = new int[order.size()];
        
        for (int i = 0; i < order.size(); i++) {
            int leaf = order.get(i);
            remainCnt[leaf]--;
            
            for (int num = 1; num <= 3; num++) {
                int nextTarget = remainTarget[leaf] - num;
                
                if (remainCnt[leaf] <= nextTarget && nextTarget <= remainCnt[leaf] * 3) {
                    answer[i] = num;
                    remainTarget[leaf] -= num;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    static int drop(int node) {
        if (tree[node].isEmpty()) {
            return node;
        }
        
        int child = tree[node].get(idx[node]);
        idx[node] = (idx[node] + 1) % tree[node].size();
        
        return drop(child);
    }
}