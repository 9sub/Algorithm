import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int tc, n,m,w;
    static ArrayList<node> adj;

    static class node implements Comparable<node>{
        int s;
        int e;
        int t;

        node(int s, int e, int t){
            this.s = s;
            this.e = e;
            this.t = t;
        }
        @Override
        public int compareTo(node o) {
            return this.t - o.t;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());



        for(int tcc=0;tcc<tc;tcc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
             n = Integer.parseInt(st.nextToken());
             m = Integer.parseInt(st.nextToken());
             w = Integer.parseInt(st.nextToken());

            adj = new ArrayList<>();
            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                adj.add(new node(s,e,t));
                adj.add(new node(e,s,t));
            }
            for(int i=0;i<w;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                adj.add(new node(s,e,-t));
            }

            if(bellmanford()) System.out.println("YES");
            else System.out.println("NO");

        }

    }

    public static boolean bellmanford(){
        int[] find = new int[n+1];
        Arrays.fill(find,0);
//        find[1] = 0;


        for(int i=1;i<=n;i++){
            boolean update = false;

            for(node p : adj){
                if(find[p.e] > find[p.s]+p.t){
                    find[p.e] = find[p.s]+p.t;
                    update = true;
                    if(i==n) return true;
                }
            }
            if(!update)break;
        }
        return false;
    }


}