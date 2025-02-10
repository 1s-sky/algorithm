import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {        
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] nAry = kb.next().split("");
        int answer = 0;
        kb.close();

        for(String s : nAry){ 
            answer += Integer.parseInt(s);
        }

        System.out.print(answer);
    }
}