import java.io.*;
import java.util.*;


public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        StringBuilder result = new StringBuilder();
        char[] binary = sb.reverse().toString().toCharArray();
        int temp = 0;
        for(int i=0; i<binary.length; i++){
            temp += Character.getNumericValue(binary[i])*Math.pow(2, i%3);

            if (i%3 == 2 || i == binary.length - 1) {
                result.append(Character.forDigit(temp,10));
                temp = 0;
            }
        }
        System.out.println(result.reverse().toString());
    }
}