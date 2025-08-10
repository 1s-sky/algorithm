import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] amount = new int[n+1][3];

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            amount[i][0] = Integer.parseInt(st.nextToken());
            amount[i][1] = Integer.parseInt(st.nextToken());
            amount[i][2] = Integer.parseInt(st.nextToken());
        }


        for(int i=1; i<=n; i++){
            amount[i][0] += Math.min(amount[i-1][1], amount[i-1][2]);
            amount[i][1] += Math.min(amount[i-1][0], amount[i-1][2]);
            amount[i][2] += Math.min(amount[i-1][0], amount[i-1][1]);
        }

        System.out.println(Math.min(Math.min(amount[n][0], amount[n][1]), amount[n][2]));
    }
}