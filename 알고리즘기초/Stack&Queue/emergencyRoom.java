import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class emergencyRoom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> patientMap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int count = 1;

        PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            patientMap.put(i, num);
            priority.offer(num);
        }

        Queue<Map.Entry<Integer, Integer>> patientQue = new ArrayDeque<>(patientMap.entrySet());

        while(patientQue.peek().getKey() != m || priority.peek() != patientMap.get(m)){
            if (patientQue.peek().getValue() != priority.peek()) //우선순위가 낮으면 뒤로
                patientQue.offer(patientQue.poll());    
            else {
                patientQue.poll(); priority.poll();
                count++;
            }
        }

        System.out.println(count);
    }
}
