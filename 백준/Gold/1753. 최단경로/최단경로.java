import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int num;
    int weight;

    public Node(int num, int weight){
        this.num = num;
        this.weight = weight;
    }

    public int compareTo(Node o){
        return this.weight - o.weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] map = new int[v+1];
        int start = Integer.parseInt(br.readLine());
        ArrayList<HashMap<Integer, Integer>> adjList = new ArrayList<>();
        PriorityQueue<Node> pQue = new PriorityQueue();

        Arrays.fill(map, Integer.MAX_VALUE);

        for(int i=0; i<v+1; i++){
            adjList.add(new HashMap<>());
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            HashMap<Integer,Integer> hMap = adjList.get(from);
            hMap.put(to, Math.min(weight, hMap.getOrDefault(to, Integer.MAX_VALUE))); //가중치 최소만 남기기
        }

        pQue.offer(new Node(start, 0));
        map[start] = 0;
        while (!pQue.isEmpty()) {
            int now = pQue.poll().num;
            for(Map.Entry<Integer, Integer> entry : adjList.get(now).entrySet()){
                if(map[entry.getKey()] > map[now] + entry.getValue()) {
                    map[entry.getKey()] = map[now] + entry.getValue();
                    pQue.add(new Node(entry.getKey(), map[entry.getKey()]));
                } 
            }
        }

        for(int i=1; i<v+1; i++){
            if (map[i] == Integer.MAX_VALUE) sb.append("INF").append('\n');
            else sb.append(map[i]).append('\n');
        }

        System.out.println(sb.toString());
    }
}