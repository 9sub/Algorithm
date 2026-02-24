import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] star;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        star = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(star[i], ' ');

        // 핵심: 한 번만 호출
        draw(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(star[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void draw(int r, int c, int size) {
        if (size == 1) {
            star[r][c] = '*';
            return;
        }

        int next = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue; // 가운데는 비움
                draw(r + i * next, c + j * next, next);
            }
        }
    }
}