import java.util.Scanner;

public class Score {
    public int solution(int[] ary){
        int answer = 0;
        int count = 0;
        for(int x : ary) {
            if(x==1) { count++; answer += count;}
            else count=0;
        }
        return answer;
    }
    public static void main(String[] args) {
        Score s = new Score();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] ary = new int[n];
        for(int i=0; i<n; i++){
            ary[i] =kb.nextInt();
        }
        System.out.println(s.solution(ary));
        kb.close();
    }
}
