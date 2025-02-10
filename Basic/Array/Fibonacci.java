package Basic.Array;
import java.util.Scanner;

public class Fibonacci {
    public static int[] solution(int n) {
        int[] fibo = new int[n];
        fibo[0] = 1;
        fibo[1] = 1;
        for(int i=2; i<n; i++){
            fibo[i] = fibo[i-2] + fibo[i-1];
        }
        return fibo;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for(int i : solution(n)){
            System.out.print(i);
            System.out.print(' ');
        }
        kb.close();
    }
}
