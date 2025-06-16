import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] in;
    static int[] post;

    public static void preOrder(int inStart, int inEnd, int postStart, int postEnd){

        if (inStart>inEnd || postStart>postEnd) {
            return;
        }

        //in-order에서 root찾기        
        int i = 0;
        while(in[inStart + i] != post[postEnd]) i++;
        
        sb.append(in[inStart+i]).append(" ");
        preOrder(inStart, inStart+i-1, postStart, postStart+i-1);
        preOrder(inStart+i+1, inEnd, postStart+i, postEnd-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        in = new int[n];
        post = new int[n];

        //in-order
        String[] order = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            in[i] = Integer.parseInt(order[i]);
        }

        //post-order
        order = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            post[i] = Integer.parseInt(order[i]);
        }

        preOrder(0, n-1, 0, n-1);

        System.out.println(sb.toString());
    }
}