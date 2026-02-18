
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int k;
	static int x;
	static int[] distance; // x와의 최단경로
	static ArrayList<Node>[] list;

	private static class Node implements Comparable<Node>{
		int idx;
		int dist;
		
		Node(int idx, int dist){
			this.idx = idx;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		
		distance = new int[n+1];
		list = new ArrayList[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i=1;i<n+1;i++) list[i] = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,1));
		}

		int cnt=0;
		dijkstra();
		for(int i=1;i<distance.length;i++) {
			if(distance[i] == k) {
				System.out.println(i);
				cnt++;
			}
		}
		if(cnt == 0)
			System.out.println(-1);
		
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(x,0));
		distance[x] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int idx = node.idx;
			int dist = node.dist;
			if(dist>distance[idx]) continue;
			for(int i=0;i<list[idx].size();i++) {
				int idx2 = list[idx].get(i).idx;
				int dist2 = list[idx].get(i).dist+dist;
				if(distance[idx2] > dist2) {
					distance[idx2] = dist2;
					pq.add(new Node(idx2, dist2));
				}
			}
		}
		
	}
	
}
