/*
1.문자 찾기
설명

한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.

입력
첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
문자열은 영어 알파벳으로만 구성되어 있습니다.

출력
첫 줄에 해당 문자의 개수를 출력한다.
 */

import java.util.Scanner;

public class SearchChar {
    public static int solution(String str, char c){
        int count = 0;
        
        // for(int i = 0 ; i < str.length(); i++){     //한 문자씩 for문을 돌면서 검사
        //     if(str.charAt(i) == c) count++;
        // }

        //향상된 for문
        for(char x : str.toCharArray()){  //향상된 for문에는 배열이 들아가야해서 string을 배열로 변환
            if(x==c) count++;
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine().toLowerCase();             //문장 입력받기
        char c = kb.next().toLowerCase().charAt(0);       //문자 입력받기
        System.out.println(solution(input, c));                 //solution()으로 정답 출력
        kb.close();
        return;
    }
}
