import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static ArrayList<int[]> empty;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr =new int[9][9];
        empty = new ArrayList<>();

        for(int i=0;i<9;i++){
            String s = br.readLine();
            for(int j=0;j<9;j++){
                arr[i][j] = s.charAt(j) - '0';
                if (arr[i][j]==0){
                    empty.add(new int[]{i,j});
                }
            }
        }
        sudoku(0);

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    static boolean isValid(int r, int c, int num){
        for(int i=0;i<9;i++){
            if(arr[r][i] == num) return false;
        }
        for(int i=0;i<9;i++){
            if(arr[i][c] == num) return false;
        }
        int sr = (r/3)*3;
        int sc = (c/3)*3;
        for(int i = sr;i<sr+3;i++){
            for(int j = sc;j<sc+3;j++){
                if(arr[i][j]==num) return false;
            }
        }
        return true;
    }

    public static boolean sudoku(int depth){

        if (depth == empty.size()) {
            return true;
        }
        int r = empty.get(depth)[0];
        int c = empty.get(depth)[1];

        for(int i=1;i<=9;i++){
            if(isValid(r,c,i)){
                arr[r][c] = i;

                if(sudoku(depth+1)) return true;

                arr[r][c] = 0;
            }
        }
        return false;
    }


}