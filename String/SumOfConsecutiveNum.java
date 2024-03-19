import java.util.Scanner;

public class SumOfConsecutiveNum {

    public static int solution(int num) {
        int answer = 0;
        int sum = 0;

        for(int i=1; i<num; i++){
            sum = 0;
            for(int j=i; j<num; j++ ){
                if(sum == num) { answer++; break; }
                else if(sum > num) break;
                else sum += j;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();
        kb.close();
        System.out.println(solution(num));
    }
}
