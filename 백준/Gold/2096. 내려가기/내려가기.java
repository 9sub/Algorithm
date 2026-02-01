import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] find_min;
    static int[][] find_max;



    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        find_min = new int[n][3];
        find_max = new int[n][3];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                int tmp = Integer.parseInt(st.nextToken());
                find_min[i][j] = tmp;
                find_max[i][j] = tmp;
            }

        }

        for(int i=1;i<n;i++){

            find_min[i][0] = Math.min(find_min[i-1][0], find_min[i-1][1]) + find_min[i][0];
            find_max[i][0] = Math.max(find_max[i-1][0], find_max[i-1][1]) + find_max[i][0];

            find_min[i][1] = Math.min(find_min[i-1][0], Math.min(find_min[i-1][1], find_min[i-1][2])) + find_min[i][1];
            find_max[i][1] = Math.max(find_max[i-1][0], Math.max(find_max[i-1][1], find_max[i-1][2])) + find_max[i][1];

            find_min[i][2] = Math.min(find_min[i-1][1], find_min[i-1][2]) + find_min[i][2];
            find_max[i][2] = Math.max(find_max[i-1][1], find_max[i-1][2]) + find_max[i][2];
        }


        int max_ = Math.max(find_max[n-1][0], Math.max(find_max[n-1][1], find_max[n-1][2]));
        int min_ = Math.min(find_min[n-1][0], Math.min(find_min[n-1][1], find_min[n-1][2]));

        System.out.println(max_ + " " + min_);

    }
}
