import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<Node>[] arr;
    static int v1, v2;
    static int[] dist;
    static int[] map;
    static int MAX = 1_000_000_000;

    static class Node implements Comparable<Node> {
        int end, weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b, w));
        }

        map = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        dijkstra(v1);

        System.out.println(dist[v2]);

        ArrayList<Integer> tmp = new ArrayList<>();
        int k = v2;

        while (k != 0) {
            tmp.add(k);
            if (k == v1) break;
            k = map[k];
        }

        System.out.println(tmp.size());

        for (int i = tmp.size() - 1; i >= 0; i--) {
            System.out.print(tmp.get(i) + " ");
        }
        System.out.println();
    }

    public static void dijkstra(int start) {
        dist = new int[n + 1];
        Arrays.fill(dist, MAX);
        Arrays.fill(map, 0);

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight > dist[cur.end]) continue;

            for (Node node : arr[cur.end]) {
                int nextDist = dist[cur.end] + node.weight;

                if (dist[node.end] > nextDist) {
                    dist[node.end] = nextDist;
                    map[node.end] = cur.end;
                    pq.add(new Node(node.end, nextDist));
                }
            }
        }
    }
}