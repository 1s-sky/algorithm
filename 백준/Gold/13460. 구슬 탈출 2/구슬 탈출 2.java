import java.util.*;
import java.io.*;
import java.lang.*;

class Balls {
    int redX;
    int redY;
    int blueX;
    int blueY;
    int cnt;

    public Balls(int redX, int redY, int blueX, int blueY, int cnt) {
        this.redX = redX;
        this.redY = redY;
        this.blueX = blueX;
        this.blueY = blueY;
        this.cnt = cnt;
    }
}

public class Main {
    static int n,m;
    static char[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        Balls balls = new Balls(0,0,0,0, 0);

        //input 세팅
        for(int i=0; i<n; i++){
            String row = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = row.charAt(j);
                if (board[i][j] == 'R') {
                    balls.redX = j;
                    balls.redY = i;
                    board[i][j] = '.';
                } 
                else if (board[i][j] == 'B') {
                    balls.blueX = j;
                    balls.blueY = i;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(balls));

    }

    static int bfs(Balls balls){
        Queue<Balls> que = new LinkedList<Balls>();
        que.offer(balls);

        while (!que.isEmpty()) {
            Balls nowBalls = que.poll();
            
            if (nowBalls.cnt >= 10) {
                return -1;
            }

            for(int i=0; i<4; i++){
                int redX = nowBalls.redX;
                int redY = nowBalls.redY;
                int blueX = nowBalls.blueX;
                int blueY = nowBalls.blueY;
                boolean isRedOut = false;
                boolean isBlueOut = false;

                //Red 이동
                while(true){
                    if (board[redY+dy[i]][redX+dx[i]] == '#') {
                        break;
                    } 
                    if (board[redY+dy[i]][redX+dx[i]] == 'O') {
                        isRedOut = true;
                        break;
                    } 
                    redX += dx[i];
                    redY += dy[i];
                }
                
                //Blue 이동
                while(true){
                    if (board[blueY+dy[i]][blueX+dx[i]] == '#') {
                        break;
                    } 
                    if (board[blueY+dy[i]][blueX+dx[i]] == 'O') {
                        isBlueOut = true;
                        break;
                    } 
                    blueX += dx[i];
                    blueY += dy[i];
                }

                if (isBlueOut) {
                    continue;
                }
                else if (isRedOut) {
                    return nowBalls.cnt + 1;
                }

                if (nowBalls.redX == redX && nowBalls.redY == redY && nowBalls.blueX == blueX && nowBalls.blueY == blueY) {
                    continue;
                }

                if (redX == blueX && redY == blueY) {
                    if (i==0) {     //오
                        if (nowBalls.redX < nowBalls.blueX) redX--;
                        else blueX--;
                    }
                    else if(i==1){  //왼
                        if (nowBalls.redX > nowBalls.blueX) redX++;
                        else blueX++;
                    }
                    else if(i==2){  //아래
                        if (nowBalls.redY > nowBalls.blueY) blueY--;
                        else redY--;
                    }
                    else {          //위
                        if (nowBalls.redY < nowBalls.blueY) blueY++;
                        else redY++;
                    }
                }

                que.offer(new Balls(redX, redY, blueX, blueY, nowBalls.cnt+1)) ;
            }
        }

        return -1;
    }
}