import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        Scanner kb = new Scanner(System.in);

        int a = kb.nextInt();
        int b = kb.nextInt();
        int c = kb.nextInt();
        kb.close();

        System.out.println((a+b)%c);
        System.out.println(((a%c)+(b%c))%c);
        System.out.println((a*b)%c);
        System.out.println(((a%c)*(b%c))%c);

    }
}