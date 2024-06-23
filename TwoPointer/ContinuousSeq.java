import java.util.Scanner;

public class ContinuousSeq {
    public static int solution(int n, int m, int[] nAry){
        int answer = 0;
        int temp = 0;
        int p1=0, p2=0;
        while(p1<n && p2<n){
            if(temp < m) { temp += nAry[p2]; p2++; }
            else if(temp > m) { temp -= nAry[p1]; p1++; }
            //동일하면 anwer++
            if(temp == m) { answer++; temp -= nAry[p1]; p1++; }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] nAry = new int[n];
        for(int i=0; i<n; i++){
            nAry[i] = kb.nextInt();
        }
        System.out.println(solution(n,m,nAry));
        kb.close();
    }
}