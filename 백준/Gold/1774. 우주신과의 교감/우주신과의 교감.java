import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parents;
	
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		double w;
		public Edge(int s, int e, double w) {
			this.s=s;
			this.e=e;
			this.w=w;
		}
		
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
	}
	
	static int n, m;
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        double[][] city = new double[n][2];
    	parents = new int[n+1];
        Arrays.fill(parents, -1);
       
        for(int i=0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	city[i][0] = Double.parseDouble(st.nextToken());
        	city[i][1] = Double.parseDouble(st.nextToken());
        }

        int count=0;
        
        for(int i=0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken())-1;
        	int v = Integer.parseInt(st.nextToken())-1;
        	if(union(u,v)) {
            	count++;        		
        	}
        }
    	        
    	ArrayList<Edge> edgeList = new ArrayList<>();
    	
    	for(int i=0; i < n; i++) {
    		for(int j=i+1; j < n; j++) {
    			double dist = Math.sqrt(Math.pow(city[i][0] - city[j][0],2) + Math.pow(city[i][1] - city[j][1], 2));
    			edgeList.add(new Edge(i,j,dist));
    		}
    	}        	

    	 
        Collections.sort(edgeList);
        
        double result=0;
        for(Edge edge : edgeList) {
        	if(union(edge.s, edge.e)) {
        		result += edge.w;
        		count++;
        	}
        	if(count==n-1) break;
        }
        System.out.printf("%.2f", result);
    }

	private static boolean union(int x, int y) {
		int xroot = find(x);
		int yroot = find(y);
		if(xroot!=yroot) {
			parents[yroot] = xroot;
			return true;
		}
		return false;
	}

	private static int find(int x) {
		if(parents[x] < 0) return x;
		return parents[x] = find(parents[x]);
	}
}