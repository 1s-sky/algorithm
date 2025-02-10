import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DeleteParenthesesChar {

    public static String solution(String str){
        StringBuilder answer = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : str.toCharArray()){
            if(c == '(') stack.push(c);
            else if(c == ')') stack.pop();
            else{
                if(stack.size() == 0) answer.append(c);
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        kb.close();
        System.out.println(solution(str));
    }
}
