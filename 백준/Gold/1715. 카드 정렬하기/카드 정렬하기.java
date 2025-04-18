import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> cards = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        long answer = 0;

        if (n == 1) {
            System.out.println(0);
            return;
        }

        for(int i=0; i<n; i++){
            cards.offer(Long.parseLong(br.readLine()));
        }

        while(cards.size() > 1) {
            long count = cards.poll() + cards.poll();
            cards.offer(count);
            answer += count;
        }

        System.out.println(answer);
    }
}