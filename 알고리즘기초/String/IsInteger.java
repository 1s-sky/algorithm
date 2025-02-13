package Basic.String;
/*
9. 숫자만 추출
설명
문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.

입력
첫줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.

출력
첫 줄에 자연수를 출력합니다.
 */

import java.util.Scanner;

public class IsInteger {
    public static int solution(String str) {
        int answer;
        StringBuilder intStr = new StringBuilder();
        char[] cAry = str.toCharArray();
        for(char c : cAry) {
            if(c>=48 && c<=57) intStr.append(c);
        }
        answer = Integer.parseInt(intStr.toString());
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.next();
        System.out.println(solution(input));
        kb.close();
    }
}
