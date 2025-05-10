import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        Queue<Integer> que = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] map = new int[n+1];
        Arrays.fill(map, -1);

        for(int i=0; i<n+1; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
        }

        que.add(x);
        map[x] = 0;
        while (!que.isEmpty()) {
            int now = que.poll();
            for(int adj : adjList.get(now)){
                if(map[adj] == -1) {
                    map[adj] = map[now] + 1;
                    que.add(adj);
                }
            }
        }

        for(int i=1; i<n+1; i++){
            if (map[i] == k) sb.append(i).append('\n');
        }

        if (sb.length() == 0) System.out.println(-1);
        else System.out.println(sb.toString());
        
    }
}