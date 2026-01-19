import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        
        int gcd = gcd(n1,n2);
        int lcm = n1*n2/gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
	
	static int gcd(int a, int b) {
		if(b==0) { return a;
		}else if(a==0) {return b;
		}else if(a>b) {return gcd(a%b,b);
		}else if(a<b) {return gcd(a,b%a);
		}else return a;
	}
	
}
