import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] size = new int[6];
        for(int i=0; i<6; i++){
            size[i] = kb.nextInt();
        }
        int t = kb.nextInt();
        int p = kb.nextInt();
        int answer_t = 0;
        
        for(int x : size){
            if(x%t==0) answer_t += x / t;
            else if(x==0) ;
            else answer_t += x / t + 1;
        }
        System.out.println(answer_t);
        System.out.print(n/p + " ");
        System.out.print(n%p);
    }
}