package Basic.Array;
import java.util.Scanner;

public class Ranking {
    public String solution(int[] ary, int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n; j++) {
                if (ary[i] < ary[j])
                    count++;
            }
            answer.append(count).append(' ');
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Ranking r = new Ranking();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = kb.nextInt();
        }
        System.out.println(r.solution(ary, n));
        kb.close();
    }
}
