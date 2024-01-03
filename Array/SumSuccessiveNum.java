import java.util.Scanner;

public class SumSuccessiveNum {
    public static int solution(int n){
        int answer = 0;
        int temp = 0;
        int p1=0, p2=0;
        for(int i=0; i<n/2+1; n++){
            if(temp == n) { answer++; }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.close();
        System.out.println(solution(n));
    }
}