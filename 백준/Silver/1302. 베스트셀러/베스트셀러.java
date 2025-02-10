import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> tMap = new TreeMap<>();
        String str, answer = null;
        int max = 0;

        for(int i=0; i<n; i++){
            str = br.readLine();
            tMap.put(str, tMap.getOrDefault(str, 0)+1);
        }

        for(String key : tMap.keySet()){
            if (max < tMap.get(key)) {
                max = tMap.get(key);
                answer = key;
            }
        }
        System.out.print(answer);
    }
}