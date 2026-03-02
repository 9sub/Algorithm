import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        int N = 50;
        int M = 49;
        sb.append(N).append(' ').append(M).append('\n');

        for (int i = N - 1; i >= 1; i--) {
            sb.append(i).append(' ').append(i + 1).append(' ').append(-1).append('\n');
        }

        System.out.print(sb.toString());
    }
}