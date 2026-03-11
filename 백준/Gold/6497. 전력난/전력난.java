import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<Node> arr;
    static int[] parent;
    static int[] rank;
    static class Node implements Comparable<Node> {
        int start;
        int next;
        int dist;
        Node(int s, int n, int d){
            this.start = s;
            this.next = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            parent = new int[m];
            for(int i=0; i<m; i++) {parent[i] = i;}
            rank = new int[m];

            if(m==0 && n==0) break;
            arr = new ArrayList<>();
            int total =0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                arr.add(new Node(x, y, z));
                total+=z;
            }
            int sum=0;
            int cnt=0;
            Collections.sort(arr);
            for(int i=0;i<arr.size();i++){
                Node node = arr.get(i);
                if(find(node.start) != find(node.next)){
                    union(node.start,node.next);
                    sum += node.dist;
                    cnt++;
                    if(cnt == m) break;
                }
            }

            System.out.println(total- sum);
        }
    }

    static void union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent == y_parent) return;

        if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }
        else if (rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else{
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }


    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }



}
