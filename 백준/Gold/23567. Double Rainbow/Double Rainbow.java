import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] pAry = new int[n];
        HashMap<Integer, Integer> pMap = new HashMap<>();
        HashMap<Integer, Integer> pSubMap = new HashMap<>();
        int start = 0, end = 0, answer = 0, num = 0;
        
        for(int i=0; i<n; i++){
            num = Integer.parseInt(br.readLine());
            pAry[i] = num;
            pMap.put(num, pMap.getOrDefault(num, 0)+1);
        }

        while(start<n && end<n){
            //end이동
            num = pAry[end];
            //p'에 값 넣기
            pSubMap.put(num, pSubMap.getOrDefault(num, 0)+1);
            //원 map에서 삭제
            if (pMap.get(num)==1) pMap.remove(num);
            else pMap.put(num, pMap.getOrDefault(num, 0)-1);

            if (pSubMap.size() == k) { 
                //start이동
                while (pSubMap.getOrDefault(pAry[start], 0)>=2 && start<=end) {
                    num = pAry[start];
                    pSubMap.put(num, pSubMap.getOrDefault(num, 0)-1);
                    pMap.put(num, pMap.getOrDefault(num, 0)+1);
                    start++;
                }
            }

            if (pMap.size()==k && pSubMap.size()==k) {
                if (answer==0) answer = end - start + 1;
                else answer = Math.min(answer, end - start + 1);
            }
            end++;
        }
        System.out.println(answer);
    }
}