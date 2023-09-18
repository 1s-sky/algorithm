/*
5. 특정문자 뒤집기
설명
영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.

입력
첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.

출력
첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 */

//알파벳 판단하기
//1. 대문자 65~90/소문자 97~122
//str.charAt(j)>=65 && str.charAt(j)<=90) || (str.charAt(j)>=97 && str.charAt(j)<=122
//2. Character.isAlphpet()

import java.util.Scanner;

public class ReversePart {
    public static String solution(String str){
        String answer;
        char[] cAry = str.toCharArray();
        int lt = 0, rt = str.length() -1;
        while(lt<rt) {
            if(!Character.isAlphabetic(cAry[lt])) lt++;
            else if(!Character.isAlphabetic(cAry[rt])) rt--;
            else{
                //swap
                char tmp = cAry[lt];
                cAry[lt] = cAry[rt];
                cAry[rt] = tmp;
                lt++;
                rt--;
            }
        } 
        answer = String.valueOf(cAry);
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(solution(str));
        kb.close();
        return;
    }
}
