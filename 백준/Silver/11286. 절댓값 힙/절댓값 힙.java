import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b)->{   if(Math.abs(a) == Math.abs(b)) return a - b;
                                                                    else return Math.abs(a)-Math.abs(b); });

        for(int i=0; i<n; i++){
            int in = Integer.parseInt(br.readLine());

            if (in == 0) {  //출력
                if (pq.isEmpty()) {
                    sb.append(0).append('\n');
                }
                else sb.append(pq.poll()).append('\n');
            }
            else {  //큐에 넣기
                pq.offer(in);
            }
        }
        System.out.println(sb.toString());
    }
}