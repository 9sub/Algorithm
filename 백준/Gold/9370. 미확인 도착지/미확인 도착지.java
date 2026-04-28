
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	static int T;
	static int n,m,t,s,g,h;
	static ArrayList<Node>[] arr;
	static int[] target;
	static int[] dist;
	static int MAX = 100_000_000;
	
	static class Node implements Comparable<Node>{
		int end, w;
		Node(int end, int w){
			this.end = end;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(w, o.w);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int k=0;k<T;k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			target = new int[t];
			
			arr = new ArrayList[n+1];
			for(int i=0;i<n+1;i++) arr[i] = new ArrayList<>();
			
			int gh=0;
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				arr[a].add(new Node(b,c));
				arr[b].add(new Node(a,c));
				if((a==g&&b==h) || (a==h && b==g)) gh=c;
			}
			for(int i=0;i<t;i++) {
				target[i] = Integer.parseInt(br.readLine());
			}
			
			dijkstra(s);
			int[] dists = dist.clone();
			dijkstra(g);
			int[] distg = dist.clone();
			dijkstra(h);
			int[] disth = dist.clone();
			
			Arrays.sort(target);
			
			for(int i=0;i<t;i++) {
				int x = target[i];
				
				int path1 = dists[g] + gh + disth[x];
				int path2 = dists[h] + gh + distg[x];
				
				if(dists[x] == path1 || dists[x]==path2) {
					System.out.print(target[i]+" ");
				}
			}
			System.out.println();
			
		}
		
	}
	
	public static void dijkstra(int start) {
		dist = new int[n+1];
		for(int i=1;i<=n;i++) {
			dist[i] = MAX;
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			for(Node next: arr[cur.end]) {
				if(dist[next.end]>dist[cur.end]+next.w) {
					dist[next.end] = dist[cur.end]+next.w;
					pq.add(new Node(next.end, dist[next.end]));
				}
			}
		}
		
	}
	
	
}