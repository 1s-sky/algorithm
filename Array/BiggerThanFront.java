import java.util.Scanner;

public class BiggerThanFront{
    public static String solution(int n, int[] nums){
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<n; i++){
            if(i==0) answer.append(nums[i]).append(' ');
            else{
                if(nums[i] > nums[i-1]) answer.append(nums[i]).append(' ');
            }
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = kb.nextInt();
        }
        System.out.println(solution(n, nums));
    }    

}