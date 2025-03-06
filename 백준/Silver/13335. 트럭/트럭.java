import java.io.*;
import java.util.*;
    
class Truck {
    int weight;
    int time;

    public Truck(int weight, int time){
        this.weight = weight;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //트럭의 수
        int w = Integer.parseInt(st.nextToken());   //다리의 길이
        int l = Integer.parseInt(st.nextToken());   //최대하중
        st = new StringTokenizer(br.readLine());
        Queue<Integer> trucks = new ArrayDeque<>();
        Queue<Truck> bridge = new ArrayDeque<>();
        int totWeight = 0;
        int totTime = 0;

        for(int i=0; i<n; i++){
            trucks.offer(Integer.parseInt(st.nextToken()));
        }
        
        while(!trucks.isEmpty()){
            totTime++;
            if (!bridge.isEmpty() && bridge.peek().time + w == totTime) {
                totWeight -= bridge.peek().weight;
                bridge.poll();
            }

            if (totWeight + trucks.peek() <= l) {
                totWeight += trucks.peek();
                bridge.offer(new Truck(trucks.poll(), totTime));
            }
        }

        while (!bridge.isEmpty()) {
            totTime++;
            if (bridge.peek().time + w == totTime) {
                bridge.poll();
            }
        }

        System.out.println(totTime);
    }
}
