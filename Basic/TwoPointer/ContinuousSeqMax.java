package Basic.TwoPointer;
import java.util.ArrayList;
import java.util.Scanner;

public class ContinuousSeqMax {
    
    public static int solution(int k, int[] arr){
        ArrayList<Integer> arr0 = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i<arr.length; i++) {
            if(arr[i] == 0) arr0.add(i);
        }

        //시작부 길이
        answer = arr0.get(k);

        for(int i = 0; i < arr0.size() - (k+1); i++){
            //중간 부분 길이 계산하기
            answer = Math.max(answer, arr0.get(i + k + 1) - arr0.get(i) - 1);
        }

        //끝부분 길이
        answer = Math.max(answer, arr.length - arr0.get(arr0.size() - k - 1) - 1);

        //Two Pointer
        // int lp = 0;
        // int cnt = 0;
        // for(int rp=0; rp<arr.length; rp++){

        //     if(arr[rp] == 0) cnt++;
        //     while(cnt > k) {
        //         if(arr[lp] == 0) cnt--;
        //         lp++;
        //     }

        //     answer = Math.max(answer, rp - lp + 1);
        // }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        

        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }

        kb.close();
        System.out.println(solution(k, arr));
    }
}