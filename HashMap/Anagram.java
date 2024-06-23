package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {

    public static boolean solution(String str1, String str2){
        HashMap<Character, Integer> hMap1 = new HashMap<>();
        HashMap<Character, Integer> hMap2 = new HashMap<>();
        boolean answer = true;

        for(char key : str1.toCharArray()){
            hMap1.put(key, hMap1.getOrDefault(key, 0) + 1);
        }

        for(char key : str2.toCharArray()){
            hMap2.put(key, hMap2.getOrDefault(key, 0) + 1);
        }

        //알파벳별 개수가 동일한지
        for(char key : hMap1.keySet()){
            if(hMap1.get(key) != hMap2.remove(key)) answer = false;
        }
        //알파벳이 동일한지
        if(hMap2.size() != 0) answer = false;

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str1 = kb.next();
        String str2 = kb.next();
        kb.close();

        if(solution(str1, str2)) System.out.println("YES");
        else System.out.println("NO");
    }
}
