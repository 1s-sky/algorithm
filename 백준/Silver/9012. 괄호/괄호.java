import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            Stack<Character> stack = new Stack<>();
            boolean isGood = true;
            String str = br.readLine();

            for(char c : str.toCharArray()){
                if(c=='('){ // '('
                    stack.push('(');
                }  
                else {  // ')'
                    if (stack.isEmpty()) {
                        isGood = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty() && isGood) {  //비었고 문제가 없으면 YES
                sb.append("YES").append("\n");
            }
            else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}