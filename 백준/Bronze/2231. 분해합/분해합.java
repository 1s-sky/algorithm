import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int answer = 0;
        int i;
        kb.close();

        for(i=1; i<n; i++){
            int temp = i;
            answer = i;
            while(temp > 0){
                answer += temp%10;
                temp /= 10;
            }
            if(answer==n) break;
        }

        if(i==n) System.out.println(0);
        else System.out.println(i);
    }
}