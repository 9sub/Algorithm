
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static String s;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		s = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder("");
		int cnt=0;
		
		for(int i=0;i<s.length();i++) {
			while(!stack.isEmpty() && (cnt<m) && stack.peek() < s.charAt(i)) {
				stack.pop();
				cnt++;
			}
			stack.add(s.charAt(i));
		}
		
		// 반례 추가
		while(cnt < m) {
			stack.pop();
			cnt++;
		}
		

		for(char c : stack) {
			sb.append(c);
		}
		System.out.println(sb);
	}
	
	
}
