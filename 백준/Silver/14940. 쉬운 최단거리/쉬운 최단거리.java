import java.util.*;
import java.io.*;

public class Main{
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, 1, 0, -1 };
    
    private static int[][] map;
    private static int[][] answer;
    private static boolean[][] visit;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        boolean isStartChecked = false;
        int startX = -1, startY = -1;
        
        map = new int[n][m];
        answer = new int[n][m];
        visit = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            
            if(!isStartChecked){
                for(int j=0; j<m; j++){
                    if(map[i][j] == 2){
                        isStartChecked = true;
                        startX = i;
                        startY = j;
                        break;
                    }
                }
            }
        }
        
        bfs(startX, startY);
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visit[i][j] && map[i][j] == 1) sb.append(-1 + " ");
                else sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    
    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visit[x][y] = true;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + DX[i];
                int nextY = current.y + DY[i];
                
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (map[nextX][nextY] == 0) continue;
                if (visit[nextX][nextY]) continue;

                queue.add(new Node(nextX, nextY));
                answer[nextX][nextY] = answer[current.x][current.y] + 1;
                visit[nextX][nextY] = true;
            }
        }
    }
}

class Node{
    public int x, y;
    public Node(int a, int b) {
        x = a;
        y = b;
    }
}