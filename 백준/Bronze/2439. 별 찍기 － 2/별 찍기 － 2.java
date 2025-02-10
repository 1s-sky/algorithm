import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {        
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.close();
        
        for(int x=1; x<=n; x++){        
            for(int i=n-x; i>0; i--){
                System.out.print(" ");
            }
    
            for(int j=0; j<x; j++){
                System.out.print("*");
            }
            
            System.out.println();
        }
    }
}