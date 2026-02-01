import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;




    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] s = br.readLine().split("-");
        
        int tt=0;
        
        for(int i=0;i<s.length;i++){
            int tmp=0;
            
            String[] add = s[i].split("\\+");
            
            for(int j=0;j<add.length;j++)
                tmp+= Integer.parseInt(add[j]);
            if(i==0) tt+=tmp;
            else tt-=tmp;
        }

        System.out.println(tt);

    }
}
