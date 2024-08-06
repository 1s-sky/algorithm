import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[2];
        int a=1, b=1;
        for(int i=0; i<t; i++) {
            String[] str = br.readLine().split(" ");
            arr[0] = Integer.parseInt(str[0]);
            arr[1] = Integer.parseInt(str[1]);

            a=1; b=1;
            while(a<=arr[1]){
                while(a*arr[0] > b*arr[1]) {
                    b++;
                }
                if (a*arr[0] == b*arr[1]) {
                    sb.append(a*arr[0]).append("\n");
                    break;
                }
                a++;
            }
        }
        System.out.println(sb.toString());
    }
}