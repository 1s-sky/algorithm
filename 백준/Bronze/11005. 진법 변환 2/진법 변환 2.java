import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        while (n>=1) {
            int mod = n%b;
            if(b>=10 && mod>=10) sb.append((char)(55 + mod));
            else sb.append(mod);
            n /= b;
        }

        System.out.println(sb.reverse().toString());
    }
}