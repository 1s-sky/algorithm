import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PostfixExpression {

    public static int solution(String str){
        Deque<Integer> stack = new ArrayDeque<>();
        int temp = 0;

        for(char c : str.toCharArray()){
            if(!(c >= '0' && c <= '9')){
                if(!stack.isEmpty()) {
                    int right = stack.pop();
                    int left = stack.pop();
                    switch (c) {
                        case '+':
                            temp = left + right;
                            break;
                        case '-':
                            temp = left - right;
                            break;
                        case '*':
                            temp = left * right;
                            break;
                        case '/':
                            temp = left / right;
                            break;
                        default:
                            break;
                    }
                    stack.push(temp);
                    continue;
                }
            }
            stack.push(Character.getNumericValue(c));
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        kb.close();

        System.out.println(solution(str));
    }
}
