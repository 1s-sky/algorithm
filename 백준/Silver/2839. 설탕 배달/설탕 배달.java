import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int five = n/5;
        for(int i=five; i>=0; i--) {
            if((n-5*i)%3 == 0) {
                System.out.println(i + (n-5*i)/3);
                return;
            } 
        }
        System.out.println(-1);
    }
}