/*
3. 문장 속 단어
설명
한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
문장속의 각 단어는 공백으로 구분됩니다.

입력
첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.

출력
첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
 */

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
