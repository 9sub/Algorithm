import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int n,m,k;
    static int[] parent;
    static int[] rank;
    static ArrayList<Node> arr;

    static class Node implements Comparable<Node> {
        int a,b;
        double dist;

        public Node(int a,int b, double dist){
            this.a=a;
            this.b=b;
            this.dist=dist;
        }

        @Override
        public int compareTo(Node o){
            return Double.compare(dist,o.dist);
        }

    }

    static class Star{
        double x,y;

        Star(double x,double y){
            this.x=x;
            this.y=y;
        }
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n =  Integer.parseInt(br.readLine());

        ArrayList<Star> star = new ArrayList<>();
        arr = new ArrayList<>();
        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++) parent[i] = i;

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            star.add(new Star(x,y));
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                arr.add(new Node(i,j,cal_dist(star.get(i).x, star.get(i).y , star.get(j).x,star.get(j).y)));
            }
        }

        Collections.sort(arr);

        double sum=0;
        int cnt = 0;

        for(int i=0;i<arr.size();i++){

            Node node = arr.get(i);
            if(find(node.a) != find(node.b)){
                union(node.a,node.b);
                sum+= node.dist;
                cnt++;
                if(cnt==n) break;

            }

        }
        System.out.printf("%.2f\n",sum);

    }


    public static double cal_dist(double x1, double y1, double x2, double y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

    public static void union(int x,int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if(x_parent == y_parent){
            return;
        }

        if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }
        else if(rank[x_parent] > rank[y_parent]){
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
