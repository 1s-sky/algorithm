import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            int[] house = new int[n];
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                house[j] = Integer.parseInt(st.nextToken());
            }

            int end = 0, money = 0;
            for(end=0; end<m; end++){   //일단 m만큼 더하기
                money += house[end];
            }

            if (money < k) count++;

            if (n==m) {
                sb.append(count).append('\n');
                continue;
            }

            for(int start=1; start<n; start++){
                money = money - house[start-1] + house[(end++)%n];
                if (money < k) count++;
            }
            
            sb.append(count).append('\n');
        } 
        System.out.println(sb.toString());
    }
}