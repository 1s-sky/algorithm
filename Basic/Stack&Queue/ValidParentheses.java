import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ValidParentheses {

    public static boolean solution(String str){
        Deque<Character> stack = new ArrayDeque<>();
        boolean answer = true;

        for(char c : str.toCharArray()){
            if(c=='(') stack.push(c);
            else {
                if(stack.isEmpty()) { answer = false; break;}
                stack.pop();
            }
        }

        if(!stack.isEmpty()) answer = false;

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        
        kb.close();

        if(solution(str)) System.out.println("YES");
        else System.out.println("NO");
    }
}
