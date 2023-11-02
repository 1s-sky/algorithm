import java.util.Scanner;

public class Peak {
    public static int solution(int n, int[][] nAry){
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                boolean flag = true;
                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(nAry[i][j] <= nAry[nx][ny]) { flag = false; break;}
                }
                if(flag) answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] nAry = new int[n+2][n+2];
        for(int i=0; i<n+2; i++){
            for(int j=0; j<n+2; j++){
                if(i==0 || i==n+1 || j==0 || j==n+1) nAry[i][j] = 0;
                else{
                    nAry[i][j] = kb.nextInt();
                }
            }
        }
        System.out.println(solution(n,nAry));
        kb.close();
    }
}
