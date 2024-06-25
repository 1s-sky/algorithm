import java.io.*;
import java.util.*;

public class Main{
    static int[] lan;
    static int k,n;
    static long answer;
    
    private static boolean isValid(long md){
        int cnt = 0;
        for(int i=0; i<k; i++){
            cnt += lan[i]/md;
        }
        if(cnt >= n) { answer = md; return true; }
        else return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        k = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        lan = new int[k];
        
        long lt, md, rt;
        
        for(int i=0; i<k; i++){
            lan[i] = Integer.parseInt(br.readLine()); 
        }
                
        if(Arrays.stream(lan).max().getAsInt() >= n){
            lt = Arrays.stream(lan).max().getAsInt() / n;
        }
        else lt = 1;      
        rt = Arrays.stream(lan).max().getAsInt();
        
        while(lt<=rt){
            md = (lt + rt) / 2;
            
            if(isValid(md)) lt = md + 1;
            else rt = md - 1;
        }
        
        System.out.println(answer);
    }
}