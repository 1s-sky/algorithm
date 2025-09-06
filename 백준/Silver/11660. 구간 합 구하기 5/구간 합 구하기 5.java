import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] num = new int[n+1][n+1];
        int[][] sum = new int[n+1][n+1];
        int[][] pos = new int[m][4];
        int answer = 0;

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                num[i][j] = Integer.parseInt(st.nextToken());
                if(i==0) sum[i][j] = num[i][j];
                else sum[i][j] = sum[i-1][j] + num[i][j];
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                sum[i][j] += sum[i][j-1];
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                pos[i][j] = Integer.parseInt(st.nextToken());
            }
            if (pos[i][0]==pos[i][2] && pos[i][1]==pos[i][3]) {
                sb.append(num[pos[i][0]][pos[i][1]]).append('\n');
            }
            else {
                answer = sum[pos[i][2]][pos[i][3]] - sum[pos[i][0]-1][pos[i][3]] 
                         - sum[pos[i][2]][pos[i][1]-1] + sum[pos[i][0]-1][pos[i][1]-1];
                sb.append(answer).append('\n'); 
            }
        }
        System.out.println(sb.toString());
    }
}