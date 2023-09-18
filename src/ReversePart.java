/*
5. 특정 문자 뒤집기
설명
영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.

입력
첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.

출력
첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 */

//대문자 65~90/소문자 97~122

import java.util.Scanner;

public class ReversePart {
    public static String solution(String str){
        StringBuilder answer = new StringBuilder();
        StringBuilder strA = new StringBuilder();
        StringBuilder strB = new StringBuilder();
        for(int i=0; i<str.length();i++){
            if((str.charAt(i)>=65 && str.charAt(i)<=90) || (str.charAt(i)>=97 && str.charAt(i)<=122)){ //알파벳이면
                strA.append(str.charAt(i));
            }
            else strB.append(str.charAt(i));
        }
        strA = strA.reverse();
        int k = 0;
        int l = 0;
        for(int j = 0; j<str.length();j++){
            if(k<strA.length()){
                if((str.charAt(j)>=65 && str.charAt(j)<=90) || (str.charAt(j)>=97 && str.charAt(j)<=122)){ //알파벳이면
                    answer.append(strA.charAt(k));
                    k++;
                }
            }
            if(l<strB.length()){
                if(!((str.charAt(j)>=65 && str.charAt(j)<=90) || (str.charAt(j)>=97 && str.charAt(j)<=122))){ //특수문자면
                    answer.append(strB.charAt(l));
                    l++;
                }
            }

        }
        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(solution(str));
        kb.close();
        return;
    }
}
