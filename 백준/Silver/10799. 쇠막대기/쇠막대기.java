import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0, level = 0;
        char before = ' ';

        for(char c : str.toCharArray()){
            if (c == '(') {
                level++;
            }
            else {
                level--;
                if (before == '(') answer += level;
                else answer++;
            }

            before = c;
        }
        System.out.println(answer);
    }
}