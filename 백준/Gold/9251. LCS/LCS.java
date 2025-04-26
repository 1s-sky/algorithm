import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int[][] dp = new int[str2.length+1][str1.length+1];
        
        for(int i=0; i<=str2.length; i++){
            for(int j=0; j<=str1.length; j++){
                if (i==0 || j==0) dp[i][j] = 0;
                else if(str1[j-1] == str2[i-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[str2.length][str1.length]);
    }
}