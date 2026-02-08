
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static String a;
	static String b;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		a = br.readLine();
		b = br.readLine();
		
		StringBuilder a_ = new StringBuilder(a);
		StringBuilder b_ = new StringBuilder(b);
		
		int flag = 0;
		
		while(b_.length()>0) {
			if(a_.toString().equals(b_.toString())) flag=1;
			
			int len = b_.length()-1;
			if(b_.charAt(len) == 'A') {
				b_.deleteCharAt(len);
			}else {
				b_.deleteCharAt(len);
				b_.reverse();
			}
		}
		if(flag == 1)System.out.println(1);
		else System.out.println(0);
		
	}
	
	
}
