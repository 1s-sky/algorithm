import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = { 1, -1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n+2][m+2];
        visited = new boolean[n+2][m+2];
        Node start = null;
        int answer;

        //초기화
        for(int i=0; i<n+2; i++){ 
            Arrays.fill(graph[i], 1);
            Arrays.fill(visited[i], false);
        }

        //입력받기
        for(int i=1; i<=n; i++){
            String[] arr = br.readLine().split("");
            for(int j=1; j<=m; j++){
                graph[i][j] = Integer.parseInt(arr[j-1]);
                if (graph[i][j] == 2) {
                    start = new Node(i, j, 0);
                }
            }
        }
        answer = bfs(start);

        if (answer != -1) {
            System.out.println("TAK");
            System.out.println(answer);
        }
        else System.out.println("NIE");

    }

    static int bfs(Node start){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            //상하좌우 탐색
            for(int i=0; i<4; i++){
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];
                if (graph[nextX][nextY] == 3 || graph[nextX][nextY] == 4 || graph[nextX][nextY] == 5) { 
                    return ++now.count; 
                }
                if (!visited[nextX][nextY] && graph[nextX][nextY] != 1) {
                    Node next = new Node(nextX, nextY, now.count+1);
                    visited[nextX][nextY] = true;
                    queue.offer(next);
                }
            }
        }
        return -1;
    }
}