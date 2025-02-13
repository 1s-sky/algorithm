package Basic.String;
import java.util.Scanner;

public class TransUpperLower {
    public static String solution(String str){
        StringBuilder answer = new StringBuilder();
        for(char c : str.toCharArray()){
            if(Character.toUpperCase(c) == c) answer.append(Character.toLowerCase(c));  //대문자면 소문자로
            else answer.append(Character.toUpperCase(c));                               //소문자면 대문자로
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution(str));
        kb.close();
        return;
    }
}
