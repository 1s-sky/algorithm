import java.util.Scanner;

public class SumArr {
    public static String solution(int n, int m, int[] nAry, int[] mAry){
        StringBuilder answer = new StringBuilder();
        int[] rAry = new int[n+m];
        for(int i=0; i<n; i++){
            rAry[i] = nAry[i];
        }
        for(int i=0; i<m; i++){
            rAry[i+n] = mAry[i];
        }

        //버블 정렬
        for(int i=0; i<n+m; i++){
            for(int j=i+1; j<n+m; j++){
                if(rAry[i] > rAry[j]){
                    //swap
                    int temp = rAry[i];
                    rAry[i] = rAry[j];
                    rAry[j] = temp;
                }
            }
        }

        for(int x : rAry){
            answer.append(x).append(' ');
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] nAry = new int[n];
        for(int i=0; i<n; i++){
            nAry[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] mAry = new int[m];
        for(int i=0; i<m; i++){
            mAry[i] = kb.nextInt();
        }
        kb.close();
        System.out.println(solution(n,m,nAry,mAry));
    }
}
