import java.util.Scanner;

public class Peak {
    public static int solution(int n, int[][] nAry){
        int answer = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(nAry[i][j] > nAry[i-1][j] && nAry[i][j] > nAry[i+1][j] 
                && nAry[i][j] > nAry[i][j-1] && nAry[i][j] > nAry[i][j+1]) answer++;
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
