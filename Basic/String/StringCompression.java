package Basic.String;
import java.util.Scanner;

public class StringCompression {
    public static String solution(String str){
        str = str + ' ';        //맨 뒤에 빈 문자 붙이기
        StringBuilder answer = new StringBuilder();
        int count = 1;

        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){       //같으면 count++
                count++;
            }
            else {                          //다르면 append 후, 초기화
                answer.append(str.charAt(i));
                if(count > 1) answer.append(count);
                count = 1;
           }
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.next();
        System.out.println(solution(input));
        kb.close();
    }
}
