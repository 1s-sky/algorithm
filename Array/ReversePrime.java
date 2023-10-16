
import java.util.Scanner;

public class ReversePrime {
    //뒤집기 함수
    public int reverse(int num){
        int res = 0;
        while(num != 0){
            res = res*10 + num%10;
            num = num/10;
        }
        return res;
    }
    //소수 판단
    public boolean isPrime(int num){
        if(num == 1) return false;
        for(int i=2; i<num; i++){
            if(num%i==0) return false;
        }
        return true;
    }
    public String solution(int[] ary, int n){
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<n;i++){
            ary[i] = reverse(ary[i]);
            if(isPrime(ary[i])) answer.append(ary[i]).append(' ');
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        ReversePrime r = new ReversePrime();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] ary = new int[n];
        for(int i=0; i<n; i++){
            ary[i] = kb.nextInt();
        }
        System.out.println(r.solution(ary, n));
        kb.close();
    }
}
