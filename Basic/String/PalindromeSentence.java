package Basic.String;
import java.util.Scanner;

public class PalindromeSentence {
    public static String solution(String str) {
        String answer = "NO";
        
        //알파벳만 걸러내기 => replaceAll을 이용하여 정규식 사용
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        String reverse = new StringBuilder(str).reverse().toString();

        //회문검사
        if(str.equals(reverse)) answer = "YES";
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(solution(str));
        kb.close();
    }
}
