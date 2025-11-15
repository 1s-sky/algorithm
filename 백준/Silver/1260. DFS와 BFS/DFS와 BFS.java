import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static List<Integer>[] nodes;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        nodes = new ArrayList[n+1];
        visited = new boolean[n+1];

        //초기화
        for(int i=1; i<=n; i++){
            nodes[i] = new ArrayList<>();
        }

        //입력받기
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }

        //sort
        for(int i=1; i<=n; i++){
            Collections.sort(nodes[i]);
        }

        dfs(s);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(s);

    }

    static void dfs(int x){
        visited[x] = true;
        System.out.print(x + " ");

        for(int next : nodes[x]){
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int x){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[x] = true;
        queue.offer(x);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for(int next : nodes[now]){
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}