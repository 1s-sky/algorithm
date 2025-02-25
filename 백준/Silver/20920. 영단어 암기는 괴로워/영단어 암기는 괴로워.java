import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> dict = new TreeMap<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            String str = br.readLine();
            if (str.length() < m) { continue; }
            
            dict.put(str, dict.getOrDefault(str, 0)+1);

        }
        
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(dict.entrySet());

        entryList.sort( new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){

                int valueCompare = o2.getValue().compareTo(o1.getValue());

                if (valueCompare != 0) { 
                    return valueCompare; 
                }
                
                return Integer.compare(o2.getKey().length(), o1.getKey().length());
            }
        });

        for(Map.Entry<String, Integer> entry : entryList){
            sb.append(entry.getKey()).append('\n');
        }

        System.out.println(sb.toString());

    }
}