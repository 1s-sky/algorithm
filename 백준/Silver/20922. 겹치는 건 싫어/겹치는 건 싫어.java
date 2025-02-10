import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] nAry = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0, start = 0, end = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nAry[i] = Integer.parseInt(st.nextToken());
        }

        while(start<n && end<n){

            map.put(nAry[end], map.getOrDefault(nAry[end], 0) + 1);

            while (map.getOrDefault(nAry[end], 0) > k) {
                map.put(nAry[start], map.getOrDefault(nAry[start], 0) - 1); 
                start++;
            }

            answer = Math.max(answer, end - start + 1);
            end++;
        }
        System.out.println(answer);
    }
}