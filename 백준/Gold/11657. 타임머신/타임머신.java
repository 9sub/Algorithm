import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int start, end;
        int w;
        Node(int from, int to, int w) {
            this.start = from;
            this.end = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node[] edges = new Node[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Node(a, b, c);
        }

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;


        for (int i = 1; i <=n; i++) {
            boolean updated = false;
            for (Node e : edges) {
                if (dist[e.start] == INF) continue;
                long nd = dist[e.start] + e.w;
                if (nd < dist[e.end]) {
                    dist[e.end] = nd;
                    updated = true;
                }
            }
            if (!updated) break; 
        }


        boolean negCycle = false;
        for (Node e : edges) {
            if (dist[e.start] == INF) continue;
            if (dist[e.start] + e.w < dist[e.end]) {
                negCycle = true;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (negCycle) {
            sb.append("-1\n");
        } else {
            for (int i = 2; i <= n; i++) {
                sb.append(dist[i] == INF ? -1 : dist[i]).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}