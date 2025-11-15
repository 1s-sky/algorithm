import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> big = new PriorityQueue<>();
        int mid = 0;

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(i==0) mid = num;

            if (num >= mid) {
                big.offer(num);
            }
            else small.offer(num);

            while (Math.abs(big.size()-small.size())>1) {
                if (big.size()>small.size())  small.offer(big.poll());
                else big.offer(small.poll());
            }

            mid = (big.size()>small.size())?big.peek():small.peek();
            sb.append(mid).append('\n');
        }
        System.out.println(sb.toString());
    }
}