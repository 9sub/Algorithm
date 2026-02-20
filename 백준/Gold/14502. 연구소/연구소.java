import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] arr;
    static ArrayList<int[]> empties;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        empties = new ArrayList<>();


        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==0){
                    empties.add(new int[] {i,j});
                }
            }
        }



        int max_=0;

        for(int i=0;i<empties.size();i++){
            for(int j=i+1;j< empties.size();j++){
                for(int k=j+1;k< empties.size();k++){
                    int[][] copy = new int[n][m];
                    for(int i2=0;i2<n;i2++){
                        for(int j2=0;j2<m;j2++){
                            copy[i2][j2] = arr[i2][j2];
                        }
                    }
                    int[] p1 = empties.get(i);
                    int[] p2 = empties.get(j);
                    int[] p3 = empties.get(k);

                    copy[p1[0]][p1[1]] = 1;
                    copy[p2[0]][p2[1]] = 1;
                    copy[p3[0]][p3[1]] = 1;

                    bfs(copy);
                    max_ = Math.max(max_, check_novirus(copy));

                }
            }
        }
        System.out.println(max_);

    }


    public static int check_novirus(int[][] copy){
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(copy[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }



    public static void bfs(int [][] copy){
        Deque<int[]> que = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(copy[i][j]==2){
                    que.add(new int[] {i,j});
                }
            }
        }


        while(!que.isEmpty()){
            int[] cur = que.poll();
            for(int i=0;i<4;i++){
                int ny = cur[0]+dy[i];
                int nx = cur[1]+dx[i];
                if(ny<0 || ny>=n || nx<0 || nx>=m) continue;

                if(copy[ny][nx] == 0){
                    copy[ny][nx] = 2;
                    que.add(new int[] {ny,nx});
                    }
                }
            }
        }







}