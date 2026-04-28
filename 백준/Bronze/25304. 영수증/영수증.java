import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        Scanner n=new Scanner(System.in);
        int x=n.nextInt();
        int nn=n.nextInt();
        int sum=0;
        for(int i=0;i<nn;i++)
        {
            int a=n.nextInt();
            int b=n.nextInt();
            sum+=(a*b);
        }
        if(sum==x)
            System.out.println("Yes");
        else System.out.println("No");
    }
}
