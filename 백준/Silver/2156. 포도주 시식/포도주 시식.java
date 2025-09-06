import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n+1];
        int[] max = new int[n+1];

        for(int i=1; i<=n; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        max[1] = wine[1];
        if (n != 1) {
            max[2] = wine[1] + wine[2];
            for(int i=3; i<=n; i++){
                max[i] = Math.max(max[i-3]+wine[i-1]+wine[i], Math.max(max[i-1], max[i-2]+wine[i]));
            }
        }

        System.out.println(max[n]);
    }
}