import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int garo, sero;
    static int n;
    static int[] arr;
    static int x;
    static int y;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        garo = Integer.parseInt(st.nextToken());
        sero = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());

        arr = new int[n];


        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int di = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            arr[i] = pos(di,dist);
        }
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int tmp = pos(x,y);
        int min_ = 0;
        for(int i=0;i<n;i++){
            min_ += Math.min(Math.abs(arr[i]-tmp), (garo*2+sero*2) - Math.abs(arr[i]-tmp));
        }
        System.out.println(min_);

    }

    static int pos(int di, int dist){
        if(di == 1) return dist;
        else if(di == 4) return garo+dist;
        else if(di==2) return garo+sero+(garo-dist);
        else if(di==3) return garo*2+sero+(sero-dist);
        return -1;
    }

}
