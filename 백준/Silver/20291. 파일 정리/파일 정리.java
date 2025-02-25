import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> tMap = new TreeMap<>();

        for(int i=0; i<n; i++){
            String ext = br.readLine().split("\\.")[1];
            tMap.put(ext, tMap.getOrDefault(ext, 0)+1);
        }

        for(Map.Entry<String, Integer> entry : tMap.entrySet()){
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append('\n');
        }

        System.out.println(sb.toString());
    }
}