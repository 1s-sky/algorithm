import java.util.*;
import java.io.*;

public class SavePrincess {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> prince = new ArrayDeque<>();
        int count = 1;

        for(int i=1; i<=n; i++){
            prince.offer(i);
        }

        while(prince.size() > 1) {
            if (count == k) { 
                prince.poll(); 
                count = 1; 
            }
            else {
                prince.offer(prince.peek());
                prince.poll();
                count++;
            }
        }
        System.out.println(prince.poll());
    }
}
