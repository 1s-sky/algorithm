package Basic.Array;
import java.util.Scanner;

public class RockPaperScissors {
    public static char[] solution(int n, int[][] ary){
        char[] answer = new char[n];
        for(int i=0; i<n; i++){
            //비겼을때
            if(ary[0][i] == ary[1][i]) answer[i] = 'D';
            //A가 이길 때
            else if(ary[0][i]==1 && ary[1][i]==3) answer[i] = 'A';
            else if(ary[0][i]==2 && ary[1][i]==1) answer[i] = 'A';
            else if(ary[0][i]==3 && ary[1][i]==2) answer[i]='A';
            //B가 이길 때
            else answer[i] = 'B';
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] ary = new int[2][n];
        for(int i=0; i<2; i++){
            for(int j=0; j<n; j++){
                ary[i][j] = kb.nextInt();
            }
        }
        for(char c: solution(n, ary)){
            System.out.println(c);
        }
        kb.close();
    }
}
