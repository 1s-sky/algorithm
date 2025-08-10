import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] count = new int[num+1];

        for (int i=2; i<=num; i++) {
                count[i] = count[i - 1] + 1; // 1을 빼는 경우
                if (i%2 == 0) count[i] = Math.min(count[i], count[i/2] + 1);
                if (i%3 == 0) count[i] = Math.min(count[i], count[i/3] + 1);
            }

        System.out.println(count[num]);
    }
}