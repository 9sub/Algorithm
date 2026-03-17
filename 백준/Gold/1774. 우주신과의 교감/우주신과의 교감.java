import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static Edge[] points;
    static ArrayList<Edge> connect;
    static ArrayList<Node> real;
    static int[] parent;
    static int[] rank;

    static class Edge{
        int x;
        int y;
        Edge(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;
        double distance;
        Node (int start, int end, double distance){
            this.start=start;
            this.end=end;
            this.distance=distance;
        }
        @Override
        public int compareTo(Node o) {
            return Double.compare(distance,o.distance);
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        points = new Edge[n+1];
        connect = new ArrayList<>();
        real = new ArrayList<>();

        parent = new int[n+1];
        for(int i=0;i<=n;i++) parent[i]=i;
        rank = new int[n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            points[i] = (new Edge(a,b));
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                real.add(new Node(i,j,cal(points[i].x, points[i].y,points[j].x,points[j].y)));

            }
        }

        Collections.sort(real);

        double sum=0;
        for(int i=0;i<real.size();i++){
            Node node = real.get(i);
            if(find(node.start)!= find(node.end)){
                union(node.start,node.end);
                sum+= node.distance;

            }
        }

        System.out.printf("%.2f\n", sum);


    }

    public static void union(int a, int b){
        int parent_a = find(a);
        int parent_b = find(b);

        if(rank[parent_a] > rank[parent_b]){
            parent[parent_b] = parent_a;
        }else if(rank[parent_a] < rank[parent_b]){
            parent[parent_a] = parent_b;
        }else{
            parent[parent_b] = parent_a;
            rank[parent_a]++;
        }

    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static double cal(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }

}
