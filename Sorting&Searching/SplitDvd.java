import java.util.Arrays;
import java.util.Scanner;

public class SplitDvd {
    
    public static boolean isMidValid(int mid, int split, int[] arr){
        int sum = 0;
        int cnt = 1;

        for(int x : arr){
            sum += x;
            if(sum > mid){
                sum = x;
                cnt++;
                if(cnt > split) return false;
            }
        }

        return true;
    }

    public static int soltuion(int split, int[] arr){
        int answer = 0;
        int left = Arrays.stream(arr).min().getAsInt();
        int right = Arrays.stream(arr).sum();

        while (left <= right) {
            int mid = (left + right) / 2;
            if(isMidValid(mid, split, arr)) {
                right = mid - 1;
                answer = mid;
            }
            else left = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int split = kb.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        kb.close();

        System.out.println(soltuion(split, arr));
    }
}
