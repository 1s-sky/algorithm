import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{       
        StringBuilder result = new StringBuilder();
        String[] temp;
        int start,end = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] pal = new boolean[n][n];
        String[] sAry = br.readLine().split(" ");

        for(int x=0; x<n; x++){
            for(int i=0; i<n; i++){
                int j = i+x;
                if (j>=n) break;

                if (i==j) pal[i][j] = true;
                else if(x==1) pal[i][j] = sAry[i].equals(sAry[j]); //대각선에서 한칸 떨어졌을때
                else pal[i][j] = pal[i+1][j-1] && sAry[i].equals(sAry[j]); //이후 모든 칸

            }
        }

        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            temp  = br.readLine().split(" ");
            start = Integer.parseInt(temp[0]) - 1;
            end   = Integer.parseInt(temp[1]) - 1;
            
            if (pal[start][end]) result.append('1').append('\n');
            else result.append('0').append('\n');
        }
        System.out.print(result.toString());
    }
}