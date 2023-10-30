import java.util.Scanner;

public class MatchMentor {
    public static int solution(int col, int row, int[][] nAry){
        int answer = 0;
        int[][] temp = new int [col][row];

        //옮겨담기
        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++){
                temp[i][nAry[i][j]-1] = j+1;
            }
        }

        //비교하기
        for(int k=0; k<row-1; k++){
            for(int l=k+1; l<row; l++){
                int flag=1;
                for(int i=0; i<col; i++){
                    if(temp[i][k] > temp[i][l]) ;
                    else flag = 0;
                }
                if(flag==1) answer++;
            }
        }

        for(int k=0; k<row-1; k++){
            for(int l=k+1; l<row; l++){
                int flag=1;
                for(int i=0; i<col; i++){
                    if(temp[i][k] < temp[i][l]) ;
                    else flag = 0;
                }
                if(flag==1) answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int row = kb.nextInt();
        int col = kb.nextInt();
        int[][] nAry = new int[col][row];

        for(int i=0; i<col; i++){
            for(int j=0; j<row; j++){
                nAry[i][j] = kb.nextInt();
            }
        }

        System.out.println(solution(col, row, nAry));
        kb.close();
    }
}