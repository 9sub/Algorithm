import java.io.*;
import java.util.*;

public class Main {
    static int v,e;
    static ArrayList<int[]> arr;
    static int[] parent, rank;
    static class node implements Comparable<node>{
        int u,v,w;

        node(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(node o) {
            return this.w - o.w;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        node[] nodes = new node[e];

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c  = Integer.parseInt(st.nextToken());
            nodes[i] = new node(a,b,c);
        }

        Arrays.sort(nodes);

        parent = new int[v+1];
        rank = new int[v+1];
        for(int i=1;i<=v;i++){ parent[i]=i;}

        long cost = 0;
        int picked=0;

        for(node e: nodes){
            if(union(e.u, e.v)){
                cost +=e.w;
                picked++;
                if(picked == v-1) break;
            }
        }
        System.out.println(cost);
    }

    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb) return false;

        if(rank[pa] <  rank[pb]){
            parent[pa] = pb;
        }else if(rank[pa] > rank[pb]){
            parent[pb] = pa;
        }else{
            parent[pb] = pa;
            rank[pa]++;
        }
        return true;
    }


}