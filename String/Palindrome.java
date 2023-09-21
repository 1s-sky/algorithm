import java.util.Scanner;

public class Palindrome {
    public static String solution(String str){
        String answer = "NO";
        String reverse = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(reverse)) answer = "YES";  //대소문자 무시하고 비교
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.next();
        System.out.println(solution(input));
        kb.close();
    }
}
