import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int start, n;
    static ArrayList<Integer>[] arr;

    static class Node {
        int num;
        int depth;
        Node(int num, int depth){
            this.num = num;
            this.depth = depth;
        }

    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=0;t<10;t++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            arr = new ArrayList[101];
            for(int i=0;i<101;i++) arr[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n/2;i++){
                int tmp1 = Integer.parseInt(st.nextToken());
                int tmp2 = Integer.parseInt(st.nextToken());
                arr[tmp1].add(tmp2);
            }
            System.out.printf("#%d %d\n",t+1,bfs());

        }


    }

    public static int bfs(){
        boolean[] visit = new boolean[101];

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(start, 0));

        int max_num=-1;
        int max_depth=-1;

        while(!que.isEmpty()){
            Node cur = que.poll();

            if(!visit[cur.num]){
                visit[cur.num] = true;

                if(cur.depth>max_depth){
                    max_depth = cur.depth;
                    max_num = cur.num;
                }else if(cur.depth == max_depth)
                    max_num = Math.max(max_num, cur.num);

                for(int tmp : arr[cur.num]){
                    que.add(new Node(tmp, cur.depth+1));
                }
            }

        }

        return max_num;
    }

}


