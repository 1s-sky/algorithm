import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[] dp = new int[k+1];
        
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for(int i=0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }   

        for(int coin : coins){
            for(int i=coin; i<=k; i++){
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }

        if (dp[k] == 100001) System.out.println(-1);
        else System.out.println(dp[k]);
    }
}