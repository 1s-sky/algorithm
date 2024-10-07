import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String expression = br.readLine();
        Stack<Character> stack = new Stack<>();
        
        for(char c : expression.toCharArray()){
            switch(c){
                case '+':
                case '-':
                case '*':
                case '/':
                    while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)){
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    while(stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(c);
                    break;
            }   
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
    
    private static int priority(char c){
        if(c=='*' || c=='/') return 2;
        else if(c=='+' || c=='-') return 1;
        else return 0;
    }
}