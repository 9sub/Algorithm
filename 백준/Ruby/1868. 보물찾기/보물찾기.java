import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static int[] order;

    static final int MAXR = 20;
    // n <= 50000 이면 tree-depth는 16 이하 정도라 20이면 충분

    static int[][] down; // 자식 방향에서 올라오는 리스트
    static int[][] up;   // 부모 방향에서 내려오는 리스트

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        parent = new int[n + 1];
        order = new int[n];

        buildRootedTree(1);

        down = new int[n + 1][];
        up = new int[n + 1][];

        // bottom-up
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            int[] cnt = new int[MAXR + 2];

            for (int v : graph[u]) {
                if (v == parent[u]) continue;
                addList(cnt, down[v], 1);
            }

            down[u] = combine(cnt);
        }

        int answer = Integer.MAX_VALUE;

        // top-down + 전체 트리 기준 계산
        for (int i = 0; i < n; i++) {
            int u = order[i];
            int[] total = new int[MAXR + 2];

            if (parent[u] != 0) addList(total, up[u], 1);

            for (int v : graph[u]) {
                if (v == parent[u]) continue;
                addList(total, down[v], 1);
            }

            int[] whole = combine(total);

            // tree-depth - 1 이 실제 질문 횟수
            answer = Math.min(answer, whole[0] - 1);

            for (int v : graph[u]) {
                if (v == parent[u]) continue;

                int[] temp = total.clone();
                addList(temp, down[v], -1);
                up[v] = combine(temp);
            }
        }

        System.out.println(answer);
    }

    static void buildRootedTree(int root) {
        int idx = 0;
        int[] stack = new int[n];
        int top = 0;

        stack[top++] = root;
        parent[root] = 0;

        while (top > 0) {
            int u = stack[--top];
            order[idx++] = u;

            for (int v : graph[u]) {
                if (v == parent[u]) continue;
                parent[v] = u;
                stack[top++] = v;
            }
        }
    }

    static void addList(int[] cnt, int[] list, int delta) {
        if (list == null) return;
        for (int x : list) cnt[x] += delta;
    }

    static int[] combine(int[] cnt) {
        int dupMax = 0;
        for (int i = MAXR; i >= 1; i--) {
            if (cnt[i] >= 2) {
                dupMax = i;
                break;
            }
        }

        int r = Math.max(1, dupMax + 1);
        while (r <= MAXR && cnt[r] > 0) r++;

        int size = 1;
        for (int i = MAXR; i > r; i--) {
            if (cnt[i] > 0) size++;
        }

        int[] res = new int[size];
        int idx = 0;

        for (int i = MAXR; i > r; i--) {
            if (cnt[i] > 0) res[idx++] = i;
        }
        res[idx] = r;

        return res;
    }
}