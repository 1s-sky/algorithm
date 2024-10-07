import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int exclude, sum = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        if(n==0) { System.out.println(0); return; }
        else { exclude = (int)Math.round((double) n*0.15); }
        
        //정렬
        Arrays.sort(arr);
        
        for(int i=exclude; i<n-exclude; i++){
            sum += arr[i];
        }
        
        System.out.println(Math.round((double) sum/(n-exclude*2)));
    }
}