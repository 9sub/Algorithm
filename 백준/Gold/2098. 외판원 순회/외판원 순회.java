import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int Arange;  // 집합 A를 비트마스크로 표현했을 때 가질 수 있는 최대 값. 즉, 2^(N-1)
    static int[][] W;  // 인접 행렬
    static int[][] D;
    static final int INF = Integer.MAX_VALUE;  // infinite 를 대변 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0 ; j < N; ++j)
                W[i][j] = Integer.parseInt(st.nextToken());
        }

        // tsp[i][A] 0번 도시에서 A에 속한 도시를 거친 후 i번 도시로 오는 최소 비용
        Arange = (int) Math.pow(2, N - 1);
        D = new int[N][Arange];

        // 구하지 않은 값은 모두 -1 로 초기화
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < Arange; ++j)
                D[i][j] = -1;

        // 초기값 설정
        D[0][0] = 0;
        for (int i = 1; i < N; ++i) {
            if (W[i][0] == 0) D[i][0] = Integer.MAX_VALUE;
            else D[i][0] = W[i][0];
        }

        System.out.println(tsp(0, Arange - 1));
    }

    public static int tsp(int i, int a) {
        
        // 이미 D[i][a] 값을 구했었다면, 해당 값을 반환
        if (D[i][a] != -1)
            return D[i][a];

        int minCost = INF;
        for (int j = 1; j < N; ++j) {
            // 1번 도시부터 (N-1)번 도시 중 a 에 속한 도시만 고려한다.
            if ((a & 1 << (j - 1)) == 0) continue;
            
            // prev = D[j][A - {j}]
            int prev = tsp(j, a & ~(1 << (j - 1)));
            
            // 갈 수 없는 루트인 경우 건너뛴다.
            if (prev == INF || W[i][j] == 0) continue;
            
            minCost = Math.min(minCost, W[i][j] + prev);
        }
        
        return D[i][a] = minCost;
    }
}