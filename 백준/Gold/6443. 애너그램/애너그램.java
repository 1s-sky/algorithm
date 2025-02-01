import java.util.*;
import java.io.*;

public class Main{
    public static void createAnagram(String anagram, TreeMap<Character, Integer> map, StringBuilder answer){
        if (map.size() == 1) {
            while (map.get(map.firstKey()) != 0) {
                anagram += map.firstKey();
                map.put(map.firstKey(), map.get(map.firstKey())-1);
            }
            answer.append(anagram).append('\n');
            return;
        }

        for(char c:map.keySet()){
            TreeMap<Character, Integer> tempMap = new TreeMap<>(map);
            int value = map.get(c);
            String tempAna = anagram + c;        //문자 하나 붙이기

            tempMap.put(c, value-1); 
            if(value == 1) {     //문자를 다썼을때
                tempMap.remove(c);
            }
            
            createAnagram(tempAna, tempMap, answer);
        }
    }

    public static void main(String args[]) throws IOException{       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String str, anagram = "";

        for(int i=0; i<n; i++){
            TreeMap<Character, Integer> originMap = new TreeMap<>();
            //문자열 입력받기
            str = br.readLine();
            for(char c : str.toCharArray()){
                originMap.put(c, originMap.getOrDefault(c, 0)+1);
            }

            //애너그램 생성
            createAnagram(anagram, originMap, answer);

        }

        System.out.print(answer.toString());
    }
}