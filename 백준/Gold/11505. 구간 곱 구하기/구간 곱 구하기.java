import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k;
    static long[] arr;
    static long[] tree;
    static final long MOD = 1000000007;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        tree = new long[n * 4];

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, n, 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m + k; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(1, n, 1, b, c);
                arr[b] = c;
            } 
            else {
                sb.append(mul(1, n, 1, b, (int)c)).append('\n');
            }
        }

        System.out.print(sb);
    }

    static long init(int start, int end, int node) {

        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return tree[node] =
                (init(start, mid, node * 2) *
                 init(mid + 1, end, node * 2 + 1)) % MOD;
    }

    static long mul(int start, int end, int node, int left, int right) {

        if (right < start || end < left) return 1;

        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        return (mul(start, mid, node * 2, left, right) *
                mul(mid + 1, end, node * 2 + 1, left, right)) % MOD;
    }

    static void update(int start, int end, int node, int idx, long val) {

        if (idx < start || idx > end) return;

        if (start == end) {
            tree[node] = val;
            return;
        }

        int mid = (start + end) / 2;

        update(start, mid, node * 2, idx, val);
        update(mid + 1, end, node * 2 + 1, idx, val);

        tree[node] =
                (tree[node * 2] * tree[node * 2 + 1]) % MOD;
    }
}