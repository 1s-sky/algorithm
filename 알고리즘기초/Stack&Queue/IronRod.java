import java.util.*;
import java.io.*;

public class IronRod {
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sAry = br.readLine().split("");
        int answer = 0, level = 0;
        String before = "";

        ArrayDeque<String> stack = new ArrayDeque<>();

        for(String c : sAry){
            if (c.equals("(")) {
                stack.push(c);
                level++;
            }
            else {
                level--;
                if (before.equals("(")) answer += level;
                else answer++;
            }

            before = c;
        }
        System.out.println(answer);
    }
}
