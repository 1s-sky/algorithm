import java.io.*;
import java.util.*;

class Tomato {
    public int x;
    public int y;

    public Tomato(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int tomatoes[][];
    static int days[][];
    static Queue<Tomato> tomQue = new ArrayDeque<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        tomatoes = new int[n][m];
        days = new int[n][m];
        boolean isAllGrown = true;
        int answer = 0;

        // 토마토 입력받기
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoes[i][j] == 0) isAllGrown = false;
                else if(tomatoes[i][j] == 1) tomQue.offer(new Tomato(i,j));
            }
        }
        
        if(isAllGrown) {  // 안익은 토마토가 없으면
            System.out.println(0);
            return;
        }

        BFS();  // 탐색시작

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(tomatoes[i][j] == 0) { System.out.println(-1); return; }
                answer = Math.max(answer, days[i][j]);
            }
        }

        System.out.println(answer);
    }    

    static void BFS(){
        while(!tomQue.isEmpty()){
            Tomato nowTom = tomQue.poll(); //하나 꺼냄
            for(int i=0; i<4; i++){
                int x = nowTom.x + dx[i];
                int y = nowTom.y + dy[i];
                if(x>=0 && x<n && y>=0 && y<m && tomatoes[x][y] == 0) {
                    tomatoes[x][y] = 1;
                    days[x][y] = days[nowTom.x][nowTom.y] + 1;
                    tomQue.offer(new Tomato(x, y));
                }
            }
        }
    }
}