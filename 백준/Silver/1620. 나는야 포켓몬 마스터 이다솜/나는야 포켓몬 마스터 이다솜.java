import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> name = new HashMap<>();
        HashMap<Integer, String> num = new HashMap<>();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String str = "";

        for(int i=1; i<=n; i++){
            str = br.readLine();
            name.put(str, i);
            num.put(i, str);
        }

        for(int j=0; j<m; j++){
            str = br.readLine();
            if (str.matches("\\d+")) sb.append(num.get(Integer.parseInt(str))).append('\n');
            else sb.append(name.get(str)).append('\n');
        }
        System.out.println(sb.toString());
    }
}