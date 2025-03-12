import java.util.*;
import java.io.*;

class Jew {
    int weight;
    int value;

    public Jew(int weight, int value){
        this.weight = weight;
        this.value = value;
    }
}

public class Main{
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Jew[] jews = new Jew[n];
        int[] bags = new int[k];
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            jews[i] = new Jew(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); 
        }

        for(int j=0; j<k; j++){
            bags[j] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jews, (o1, o2) -> o1.weight - o2.weight);  //무게를 오름차순으로 정렬
        Arrays.sort(bags);

        int l = 0;
        for(int bag : bags){
            while (l<n && jews[l].weight <= bag) {
                pQueue.offer(jews[l].value);
                l++;
            }

            if (!pQueue.isEmpty()) {
                answer += pQueue.poll();
            }
        }

        System.out.println(answer);
    }
}