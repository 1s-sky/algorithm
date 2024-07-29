import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();

        for(int i=0; i<Integer.parseInt(input[0]); i++) {
            String[] pw = br.readLine().split(" ");
            map.put(pw[0], pw[1]);
        }

        for(int i=0; i<Integer.parseInt(input[1]); i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }

        System.out.print(sb.toString());
    }
}