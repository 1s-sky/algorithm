import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        LinkedList<Integer> circle = new LinkedList<>();
        int index = 0;
        
        for(int i=1; i<=n; i++){
            circle.add(i);
        }

        sb.append("<");

        while(!circle.isEmpty()){
            index += (k - 1);
            while(index >= circle.size()) index -= circle.size();
            sb.append(circle.remove(index)).append(", ");
        }

        //마지막 , 지우기
        sb.setLength(sb.length() - 2);
        sb.append(">");

        System.out.println(sb.toString());
    }
}