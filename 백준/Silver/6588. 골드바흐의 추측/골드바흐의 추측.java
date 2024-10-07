import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        final int MAX = 1000000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[MAX + 1];

        //소수 구하기 - false : 소수
        arr[0] = arr[1] = true; // 0과 1은 소수가 아님
        for (int i = 2; i < Math.sqrt(MAX); i++) {
            if (!arr[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    arr[j] = true;
                }
            }
        }

        while (n!=0) {
            String temp = "";

            for(int i=3; i<n; i++){
                //n = a+b에서 a,b가 소수이면 정답!
                if(!arr[i] && !arr[n-i]){
                    temp = n + " = " + i + " + " + (n-i);
                    break;
                }
            }

            if(!temp.equals("")) sb.append(temp).append("\n");
            else sb.append("Goldbach's conjecture is wrong.").append("\n");
            n = Integer.parseInt(br.readLine());
        }

        System.out.println(sb.toString());

    }
}