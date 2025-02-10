package Basic.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class SalesRecord {
    public static int[] solution(int n, int k, int[] arr){
        HashMap<Integer, Integer> hMap = new HashMap<>();   
        int[] answer = new int[n - k + 1];
        int rp = k, lp = 0;
        
        for(int i=0; i<k; i++){     
            hMap.put(arr[i], hMap.getOrDefault(arr[i], 0) + 1);
        }
        answer[lp] = hMap.size();

        while (rp < n) {
            //왼쪽 빼기
            hMap.put(arr[lp], hMap.get(arr[lp]) - 1);
            if(hMap.get(arr[lp]) == 0) hMap.remove(arr[lp]);

            //오른쪽 더하기
            hMap.put(arr[rp], hMap.getOrDefault(arr[rp], 0) + 1);
            
            lp++;rp++;
            answer[lp] = hMap.size();
        }

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

        for(int answer : solution(n, k, arr)){
            System.out.print(answer);
            System.out.print(' ');
        }
    }
}
