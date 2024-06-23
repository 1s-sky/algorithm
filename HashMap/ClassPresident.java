package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class ClassPresident {

    public static char solution(int n, String str){
        HashMap<Character, Integer> hMap = new HashMap<>();
        char answer = ' ';
        int max = 0;

        for(char key : str.toCharArray()) {
            hMap.put(key, hMap.getOrDefault(key, 0) + 1);
        }
        for(char key : hMap.keySet()){
            if(max < hMap.get(key)) {
                max = hMap.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        kb.close();
        System.out.println(solution(n,str));
    }
}
