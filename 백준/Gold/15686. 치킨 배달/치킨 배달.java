import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] arr;
    static ArrayList<Dot> chicken, house;
    static Stack<Dot> select;
    static int answer = Integer.MAX_VALUE;
    static class Dot{
        int i,j;
        public Dot(int i, int j){
            this.i = i;
            this.j = j;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        chicken = new ArrayList();
        house = new ArrayList();
        select = new Stack<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    house.add(new Dot(i,j));
                }
                if(arr[i][j]==2){
                    chicken.add(new Dot(i,j));
                }
            }
        }

        selectChicken(0,0);
        System.out.println(answer);

    }

    public static void selectChicken(int start, int depth){
        if(depth == m){
            int sum=0;
            for(int a=0;a<house.size();a++){
                int i = house.get(a).i;
                int j = house.get(a).j;
                int min = Integer.MAX_VALUE;
                for(Dot d: select){
                    int i2 = d.i;
                    int j2 = d.j;
                    min = Math.min(min, distance(i,j,i2,j2));
                }
                sum+=min;
            }
            answer = Math.min(answer, sum);
            return ;
        }
        for(int i=start;i<chicken.size();i++){
            select.push(new Dot(chicken.get(i).i,chicken.get(i).j));
            selectChicken(i+1, depth+1);
            select.pop();
        }

    }

    public static int distance(int i1, int j1, int i2, int j2){
        return Math.abs(i1-i2)+Math.abs(j1-j2);
    }



}