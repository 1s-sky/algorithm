package Basic.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinExchange  {
    public static int knapsack(int[] coin, int[] count, int maxMoney){
        if (maxMoney < 0) return Integer.MAX_VALUE;
        else if(count[maxMoney] != Integer.MAX_VALUE) return count[maxMoney];
 
        for(int x : coin) {
            int temp = knapsack(coin, count, maxMoney-x);
            if (count[maxMoney] > temp) {
                count[maxMoney] = temp + 1;
            }
        }
        return count[maxMoney];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] coin = new int[n];
        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(st.nextToken());
        }
        int maxMoney = Integer.parseInt(br.readLine());
        int[] count = new int[maxMoney+1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;

        knapsack(coin, count, maxMoney);
        System.out.println(count[maxMoney]);
    }
}