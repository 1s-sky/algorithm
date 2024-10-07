import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" "); 
            for(String x : str){
                char[] cAry = x.toCharArray();
                char temp;
                for(int j=0; j<cAry.length/2; j++){    // swap
                    temp = cAry[j];
                    cAry[j] = cAry[cAry.length - 1 - j];
                    cAry[cAry.length - 1 - j] = temp;
                }
                sb.append(cAry).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}