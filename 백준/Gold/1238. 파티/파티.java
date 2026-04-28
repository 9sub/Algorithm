import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	
	static class Node implements Comparable<Node>{
		int next, weight;
		
		Node(int next, int weight){
			this.next = next;
			this.weight  = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(weight, o.weight);
		}
		
	}
	
	static int n,m,x;
	static ArrayList<Node>[] arr;
	static int[] dist;
	static int MAX = 10000000;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n =Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		dist = new int[n+1];
		
		
		for(int i=0;i<n+1;i++) arr[i] = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a].add(new Node(b,c));
		}
		
		int real_max=0;
		
		for(int i=1;i<=n;i++) {
			dijkstra(i);
			int tmp = dist[x];
			dijkstra(x);
			tmp+= dist[i];
			if(real_max<tmp)
				real_max = tmp;
		}
		System.out.println(real_max);
	}
	
	
	public static void dijkstra(int start) {
		for(int i=0;i<n+1;i++) dist[i] = MAX; 
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for(Node next: arr[cur.next]) {
				if(dist[next.next] > dist[cur.next] + next.weight) {
					dist[next.next] = dist[cur.next] + next.weight;
					pq.add(new Node(next.next, dist[next.next] ));
				}
			}
			
		}
		
		
		
	}
	
}