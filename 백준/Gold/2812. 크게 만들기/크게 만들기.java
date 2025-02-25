import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> nStack = new ArrayDeque<>();

        char[] num = br.readLine().toCharArray();
        for(char c : num){
            if (nStack.isEmpty() || count == k) { nStack.push(c); continue; }

            while (!nStack.isEmpty() && nStack.peek() < c) {
                if (count == k) {
                    break;
                }
                nStack.pop(); 
                count++;
            }
            nStack.push(c);

        }

        while (!nStack.isEmpty()) {
            sb.append(nStack.pop());
        }

        System.out.println(sb.reverse().toString().substring(0, n-k));
    }
}