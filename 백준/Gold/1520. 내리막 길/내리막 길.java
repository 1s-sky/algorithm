import java.io.*;
import java.util.*;

class Node {
    int beforeCnt;
    int x;
    int y;

    public Node(int beforeCnt, int x, int y){
        this.beforeCnt = beforeCnt;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int m,n;
    static int[][] map, count;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    
    static int dfs(int x, int y){
        if(y==m-1 && x==n-1) return 1;
        if (count[y][x] != -1) return count[y][x];
        
        count[y][x] = 0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<m && map[ny][nx] < map[y][x]) count[y][x] += dfs(nx, ny);
        }

        return count[y][x];
    } 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        count = new int[m][n];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
                count[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
    }
}