import java.util.Scanner;

public class SumSuccessiveNum {
    public static int solution(int n){
        int answer = 0;
        int sum = 0, lp = 0;
        int[] arr = new int[n/2+1];
        for(int i=0; i<arr.length; i++) arr[i] = i+1; 
        for(int rp=0; rp<arr.length; rp++){
            sum += arr[rp];

            while(sum > n) { sum -= arr[lp]; lp++;} 
            if(sum == n) answer++;
        }





        //수학 공식
        // int cnt = 1;

        // n--;
        // while(n>0){
        //     cnt++;
        //     n -= cnt;
        //     if(n%cnt==0) answer++;
        // }

        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.close();
        System.out.println(solution(n));
    }
}