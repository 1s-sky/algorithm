import java.util.*;
import java.io.*;

public class Main{
    static final int[] DX = { 0, 1, -1, 0 };
    static final int[] DY = { 1, 0, 0, -1 };
    
    static int[][] map, distance;
    static boolean[][] visit;
    static int n,m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        
        map = new int[n][m];
        distance = new int[n][m];
        visit = new boolean[n][m];
        
        //지도 입력받기
        for(int i=0; i<n; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();     
        }
        //거리계산
        distance[0][0] = 1;
        bfs(0,0);
        //출력
        System.out.print(distance[n-1][m-1]);
    }
    
    private static void bfs(int x, int y){
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x,y));
        visit[x][y] = true;
        
        while(!que.isEmpty()){
            Node cur = que.poll();
            for(int i=0; i<4; i++) {
                int nextX = cur.x + DX[i];
                int nextY = cur.y + DY[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if(map[nextX][nextY] == 0) continue;
                if(visit[nextX][nextY]) continue;
                
                que.offer(new Node(nextX, nextY));
                distance[nextX][nextY] = distance[cur.x][cur.y] + 1;
                visit[nextX][nextY] = true;
            }
        }
    }
    
}

class Node{
    int x, y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}