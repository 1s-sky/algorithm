package Basic.Array;
import java.util.Arrays;
import java.util.Scanner;

public class GridSum {
    public int solution(int[][] ary, int n){
        int[] row = new int[n];
        int[] col = new int[n];
        int cross1 = 0, cross2 = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                col[i] += ary[i][j];
                row[j] += ary[i][j];
                if(i==j) cross1 += ary[i][j];
                if(i==(n-j)) cross2 += ary[i][j];
            }
        }
        Arrays.sort(row);
        Arrays.sort(col);

        if(row[n-1]>=col[n-1] && row[n-1]>=cross1 && row[n-1]>=cross2) return row[n-1];
        else if(col[n-1]>=row[n-1] && col[n-1]>=cross1 && col[n-1]>=cross2) return col[n-1];
        else if(cross1>=row[n-1] && cross1>=col[n-1] && cross1>=cross2) return cross1;
        else return cross2;
    }
    public static void main(String[] args) {
        GridSum g = new GridSum();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] ary = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ary[i][j] = kb.nextInt();
            }
        }
        System.out.println(g.solution(ary, n));
        kb.close();
    }
}
