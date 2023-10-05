/*
10. 가장 짧은 문자거리
설명
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

입력
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
문자열의 길이는 100을 넘지 않는다.

출력
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
*/

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class LengthBtwLetter {
    public static int min(int[] iAry) {
        Arrays.sort(iAry);
        return iAry[0];
    }
    public static String solution(String str, char t) {
        StringBuilder answer = new StringBuilder();
        int[] iAry;
        Vector<Integer> indexV = new Vector<>();
        //각 문자 t의 index를 Vector에 담는다.
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == t) indexV.add(i); 
        }
        //Vector크기만한 int배열 생성
        iAry = new int[indexV.size()];

        for(int i=0; i<str.length(); i++){
            for(int j=0; j<indexV.size(); j++){
                //각 문자 t와의 거리를 iAry에 담는다.
                iAry[j] = Math.abs(i-indexV.get(j));  
            }
            //iAry의 최솟값을 answer에 넣는다.
            answer.append(Character.forDigit(min(iAry),10));
            answer.append(' ');
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char t = kb.next().charAt(0);
        System.out.println(solution(str, t));
        kb.close();
    }
}
