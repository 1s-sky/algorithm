import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        int count = 0;
        char before = ' ';

        for(char c : str.toCharArray()){
            if(c == '(') {  //'('일 때
                stack.push('(');
            }
            else {  //')'일 때
                stack.pop();
                if(before == '('){  //()이면 레이저
                    count += stack.size();
                }
                else{               //쇠막대기 끝
                    count++;
                }
            }
            before = c;
        }
        System.out.println(count);
    }
}