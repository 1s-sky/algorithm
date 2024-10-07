import java.io.*;
import java.util.*;


public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean isSecond = false;
        int sum = 0, max = 0, freq = 0, second = 0;
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> tMap = new TreeMap<>();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            tMap.put(arr[i], tMap.getOrDefault(arr[i],0) + 1);
        }
        
        for(int key : tMap.keySet()){
            if (tMap.get(key) > max) {
                freq = key;
                max = tMap.get(key);
                isSecond = false;
            }
            else if(tMap.get(key) == max && !isSecond){
                isSecond = true;
                second = key;
            }
        }
        
        Arrays.sort(arr);
        sb.append(Math.round((float)sum/n)).append("\n");   //산술평균
        sb.append(arr[n/2]).append("\n");                   //중앙값
        if (isSecond) sb.append(second).append("\n");       //최빈값
        else sb.append(freq).append("\n");
        sb.append(arr[arr.length-1] - arr[0]).append("\n"); //범위

        System.out.println(sb.toString());
    }
}