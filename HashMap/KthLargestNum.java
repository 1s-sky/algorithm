package HashMap;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class KthLargestNum {

    public static int solution(int k, int[] arr){
        TreeMap<Integer, Integer> tMap = new TreeMap<>(Comparator.reverseOrder());
        int answer = -1, cnt = 0;

        for(int a=0; a<arr.length; a++){
            for(int b=a+1; b<arr.length; b++){
                for(int c=b+1; c<arr.length; c++){
                    tMap.put(arr[a]+arr[b]+arr[c], arr[a]+arr[b]+arr[c]);
                }
            }
        }

        for(int key : tMap.keySet()){
            cnt++;
            if(cnt == k) answer = tMap.get(key);
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
        System.out.println(solution(k, arr));
    }
}
