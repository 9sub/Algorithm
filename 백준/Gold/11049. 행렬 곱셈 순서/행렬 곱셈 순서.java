import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][2]; // 입력 매트릭스를 기록하는 배열
        for (int i = 0; i < N; i++) {
            StringTokenizer stN = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(stN.nextToken());
            int c = Integer.parseInt(stN.nextToken());

            matrix[i][0] = r;
            matrix[i][1] = c;
        }

        // DP에서 사용할 연산의 최솟값을 기록하는 배열
        // 세로는 시작점, 가로는 끝점을 나타낸다.
        int[][] minOps = new int[N][N];

        // 길이가 1인 경우는 연산이 0이다.
        for (int i = 0; i < N; i++) {
            minOps[i][i] = 0;
        }

        // 길이가 2인 경우부터 N인 경우까지 진행한다.
        for (int i = 0; i < N-1; i++) {
            // 시작 인덱스는 0부터, 인덱스+길이-1이 N이 되기 전까지 순회한다.
            for (int startIdx = 0; i+startIdx+1 < N; startIdx++) {
                int endIdx = startIdx+i+1;
                // 길이가 2인 경우에는 계산한 값이 없으므로 그냥 계산해서 기록한다.
                if (i == 0) {
                    int A = matrix[startIdx][0];
                    int B = matrix[startIdx][1];
                    int C = matrix[endIdx][1];
                    int ops = A*B*C;

                    minOps[startIdx][endIdx] = ops;
                }
                // 시작점이 포함된 부분과 끝점이 포함된 부분을 더하며 비교한다.
                // 이는 기존 연산값 + 새로 합치는 연산값을 기반으로 비교해야 한다.
                else {
                    // 시작점 부분의 길이가 1인 것부터, i+1까지 가능하다.
                    // startIdx~startIdx+k 와 startIdx+k+1~endIdx를 더한다.

                    int minOpsNow = Integer.MAX_VALUE;

                    for (int k = 0; k < i+1; k++) {
                        int A = matrix[startIdx][0];
                        int B = matrix[startIdx+k][1];
                        int C = matrix[endIdx][1];
                        int ops = A*B*C;

                        ops += minOps[startIdx][startIdx+k];
                        ops += minOps[startIdx+k+1][endIdx];

                        minOpsNow = Math.min(minOpsNow, ops);
                    }

                    minOps[startIdx][endIdx] = minOpsNow;
                }
            }
        }

        // 0부터 N-1까지를 모두 고려한 최소 연산 값이 정답이다.
        int answer = minOps[0][N-1];

        System.out.println(answer);
    }
}