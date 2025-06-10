import java.io.*;
import java.util.*;

public class Main {
    static int[] tree = new int[10000];
    static StringBuilder sb = new StringBuilder();

    public static void post(int start, int end){

        if (start >= end) {
            return;
        }

        int i=0;
        for(i=start+1; i<end; i++){
            if (tree[start] < tree[i]) break;
        }

        post(start+1, i);
        post(i, end);
        sb.append(tree[start] + "\n");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        String str;

        while((str = br.readLine()) != null){
            tree[i++] = Integer.parseInt(str);
        }

        post(0, i);

        System.out.println(sb.toString());
    }
}