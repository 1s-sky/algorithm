import java.io.*;
import java.util.*;

public class Main{
    
    static int[][] fibo = new int[41][2];
    
    private static void fibonacci(int n) {
        
        if (n == 0) {
            fibo[0][0] = 1;
            fibo[0][1] = 0;
        } else if (n == 1) {
            fibo[1][0] = 0;
            fibo[1][1] = 1;
        } else {
            if(fibo[n-2][0] == 0) fibonacci(n-2);
            if(fibo[n-1][0] == 0) fibonacci(n-1);
            
            fibo[n][0] = fibo[n-1][0] + fibo[n-2][0];
            fibo[n][1] = fibo[n-1][1] + fibo[n-2][1];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i : arr){
            fibonacci(i);
            sb.append(fibo[i][0] + " " + fibo[i][1]).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}