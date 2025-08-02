import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println("? 1");
        int first = Integer.parseInt(br.readLine());
        
        System.out.println("? " + n);
        int last = Integer.parseInt(br.readLine());

        System.out.println("! " + (last-first));
    }
}