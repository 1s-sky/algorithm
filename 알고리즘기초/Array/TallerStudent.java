package Basic.Array;
import java.util.Scanner;

public class TallerStudent {
    public static int solution(int n, int[] height){
        int max = 0, count = 0;
        for(int i : height){
            if(i > max) {
                count++;
                max = i;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] height = new int[n];
        for(int i=0; i<n; i++){
            height[i] = kb.nextInt();
        }    
        System.out.println(solution(n, height));
        kb.close();
    }
}
