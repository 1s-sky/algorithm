import java.util.Arrays;
import java.util.Scanner;

public class SearchCommon {
    public static String solution(int n, int m, int[] nAry, int[] mAry){
        StringBuilder answer = new StringBuilder();
        Arrays.sort(nAry);
        Arrays.sort(mAry);
        int pn=0, pm=0;
        while(pn<n && pm<m){
            if(nAry[pn]==mAry[pm]){answer.append(nAry[pn]).append(" ");pn++;pm++;}
            else if(nAry[pn] > mAry[pm]) {pm++;}
            else {pn++;}
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
        int [] mAry = new int[m];
        for(int i=0; i<m; i++){
            mAry[i] = kb.nextInt();
        }
        kb.close();
        System.out.println(solution(n,m,nAry,mAry));
    }
}
