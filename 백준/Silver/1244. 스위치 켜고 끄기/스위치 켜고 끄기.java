import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] led;
	static int student;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		led = new int[n];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			led[i] = Integer.parseInt(st.nextToken());
		}
		
		student = Integer.parseInt(br.readLine());
		for(int i=0;i<student;i++) {
			st = new StringTokenizer(br.readLine());
			int man_or_woman = Integer.parseInt(st.nextToken());
			int led_num = Integer.parseInt(st.nextToken());
			make_led(man_or_woman, led_num);
		}
		
		for(int i=0;i<n;i++) {
            System.out.printf("%d ",led[i]);
            if((i+1)%20 == 0)
                System.out.println();

		}
		System.out.println();
		
		
	}
	
	public static void make_led(int man_or_woman, int led_num) {
		if(man_or_woman == 1) {
			for(int i=0;i<n;i++) {
				if((i+1)%led_num == 0) {
					led[i] = Math.abs(led[i]-1);
				}
			}
		}else {
			int start = led_num-1;
			led[start] = Math.abs(led[start]-1);
			int front = start-1;
			int end = start+1;
			while(true) {
				if(front<0 || end>=n) break;
				if(led[front] != led[end]) break;
				else {
					int tmp = Math.abs(led[front]-1);
					led[front] = tmp;
					led[end] = tmp;
				}
				front--;
				end++;
			}
			
		}
	}

}
