import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1=0;
        long sum2=0;
        int cnt=0;


        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();



        for(int q : queue1) {
            sum1 += q;
            que1.offer(q);
        }
        for(int q : queue2) {
            sum2+= q;
            que2.offer(q);
        }
        if((sum1+sum2)%2 == 1) return -1;
        
        
        long target = (sum1+sum2)/2;

        while(cnt <= queue1.length * 3){
            if(sum1 == target) return cnt;

            if(sum1>target){
                int tmp = que1.poll();
                sum1 -= tmp;
                que2.offer(tmp);
            }else{
                int tmp = que2.poll();
                sum1 += tmp;
                que1.offer(tmp);
            }
            cnt++;
        }
        return -1;
    }
}