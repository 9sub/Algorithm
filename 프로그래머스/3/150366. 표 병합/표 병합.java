import java.util.*;

class Solution {

    static int[] parent;
    static String[] value;

    public String[] solution(String[] commands) {
        ArrayList<String> answer = new ArrayList<>();

        parent = new int[2501];
        value = new String[2501];

        for (int i = 1; i <= 2500; i++) {
            parent[i] = i;
        }

        for (String command : commands) {
            String[] cmd = command.split(" ");

            if (cmd[0].equals("UPDATE")) {
                if (cmd.length == 4) {
                    int r = Integer.parseInt(cmd[1]);
                    int c = Integer.parseInt(cmd[2]);
                    String val = cmd[3];

                    int idx = getIndex(r, c);
                    int root = find(idx);

                    value[root] = val;
                } else {
                    String val1 = cmd[1];
                    String val2 = cmd[2];

                    for (int i = 1; i <= 2500; i++) {
                        if (value[i] != null && value[i].equals(val1)) {
                            value[i] = val2;
                        }
                    }
                }
            } else if (cmd[0].equals("MERGE")) {
                int r1 = Integer.parseInt(cmd[1]);
                int c1 = Integer.parseInt(cmd[2]);
                int r2 = Integer.parseInt(cmd[3]);
                int c2 = Integer.parseInt(cmd[4]);

                merge(r1, c1, r2, c2);

            } else if (cmd[0].equals("UNMERGE")) {
                int r = Integer.parseInt(cmd[1]);
                int c = Integer.parseInt(cmd[2]);

                unmerge(r, c);

            } else if (cmd[0].equals("PRINT")) {
                int r = Integer.parseInt(cmd[1]);
                int c = Integer.parseInt(cmd[2]);

                int idx = getIndex(r, c);
                int root = find(idx);

                if (value[root] == null) {
                    answer.add("EMPTY");
                } else {
                    answer.add(value[root]);
                }
            }
        }

        return answer.toArray(new String[0]);
    }

    static int getIndex(int r, int c) {
        return (r - 1) * 50 + c;
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void merge(int r1, int c1, int r2, int c2) {
        int idx1 = getIndex(r1, c1);
        int idx2 = getIndex(r2, c2);

        int root1 = find(idx1);
        int root2 = find(idx2);

        if (root1 == root2) {
            return;
        }

        String val1 = value[root1];
        String val2 = value[root2];

        parent[root2] = root1;

        if (val1 != null) {
            value[root1] = val1;
        } else {
            value[root1] = val2;
        }

        value[root2] = null;
    }

    static void unmerge(int r, int c) {
        int idx = getIndex(r, c);
        int root = find(idx);
        String keepValue = value[root];

        ArrayList<Integer> group = new ArrayList<>();

        for (int i = 1; i <= 2500; i++) {
            if (find(i) == root) {
                group.add(i);
            }
        }

        for (int cell : group) {
            parent[cell] = cell;
            value[cell] = null;
        }

        value[idx] = keepValue;
    }
}