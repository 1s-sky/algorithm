import java.util.Scanner;

public class SlidingWindow {
    public static int solution(int n, int k, int[] nAry){
        int answer = 0, sum = 0;
        for(int i=0; i<k; i++){
            answer += nAry[i];
        }
        sum = answer;
        for(int i=k; i<n; i++){
            sum = sum + nAry[i] - nAry[i-k];
            if(sum>answer) answer = sum;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] nAry = new int[n];
        for(int i=0; i<n; i++){
            nAry[i] = kb.nextInt();
        } 
        System.out.println(solution(n,k,nAry));
        kb.close();
    }
}