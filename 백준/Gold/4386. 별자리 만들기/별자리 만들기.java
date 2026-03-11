import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int n,m,k;
    static boolean[] visit;
    static int[] rank;
    static ArrayList<Node>[] arr;

    static class Node implements Comparable<Node> {
        int b;
        double dist;

        public Node(int b, double dist){
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
        arr = new ArrayList[n];
        for(int i=0;i<n;i++){
            arr[i] = new ArrayList<>();
        }


        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            star.add(new Star(x,y));
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                arr[i].add(new Node(j,cal_dist(star.get(i).x, star.get(i).y, star.get(j).x,star.get(j).y)));
                arr[j].add(new Node(i,cal_dist(star.get(i).x, star.get(i).y, star.get(j).x,star.get(j).y)));
            }
        }

        prim(0);

    }


    public static double cal_dist(double x1, double y1, double x2, double y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }


    public static void prim(int start){
        visit = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        double sum=0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visit[node.b]) continue;

            visit[node.b] = true;
            sum+= node.dist;

            for(Node n:arr[node.b]){
                pq.add(n);
            }
        }
        System.out.printf("%.2f\n", sum);
    }

}
