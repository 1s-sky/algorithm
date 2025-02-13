package Basic.String;
import java.util.Scanner;

public class SearchLongWord {
    public static String solution(String str){
        String[] arr = str.split(" ");
        String answer = "";
        for(String temp : arr){
            if(answer.length() < temp.length()) answer = temp;
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println(solution(kb.nextLine()));
        kb.close();
        return;
    }
    
}
