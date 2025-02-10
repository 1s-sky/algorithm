package Basic.Array;
import java.util.Scanner;

public class SelectLeader {
    public static int solution(int n, int[][] nAry){
        int answer = 1;
        int max = 0;
        int[][] count = new int[n][n];
        //[n][i]값이 동일하면 채크
        for(int i=0; i<5; i++){
            for(int j=0; j<n; j++){
                int temp = nAry[j][i];
                for(int k=j+1; k<n; k++){
                    if(nAry[k][i]==temp) {count[k][j] = 1; count[j][k] = 1;}
                }
            }
        }
        //최댓값 찾기
        for(int i=0; i<n; i++){
            int temp = 0;
            for(int j=0; j<n;j++){
                temp += count[i][j];
            }
            if(temp > max) { max = temp; answer = i+1;}
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb. nextInt();
        int[][] nAry = new int[n][5];
        for(int i=0; i<n; i++){
            for(int j=0; j<5; j++){
                nAry[i][j] = kb.nextInt();
            }
        }
        System.out.println(solution(n, nAry));
        kb.close();
    }
}