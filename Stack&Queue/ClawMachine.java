import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ClawMachine {
    public static int solution(int n, int[][] arr, int[] move) {
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        for(int j=0; j<move.length; j++){
            int index = move[j] - 1;
            for(int i=0; i<n; i++){
                if(arr[i][index] != 0) {

                    if(!stack.isEmpty()){
                        if(stack.peek() == arr[i][index]) {
                            
                            arr[i][index] = 0;
                            stack.pop();
                            answer++;
                            break;
                        }
                    }

                    stack.push(arr[i][index]);
                    arr[i][index] = 0;
                    break;
                }
            }
        }

        return answer*2;
    }
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = kb.nextInt();
            }
        }

        int k = kb.nextInt();
        int[] move = new int[k];

        for(int i=0; i<k; i++){
            move[i] = kb.nextInt();
        }

        kb.close();
        System.out.println(solution(n, arr, move));
    }
}
