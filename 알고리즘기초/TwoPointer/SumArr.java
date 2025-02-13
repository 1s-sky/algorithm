package Basic.TwoPointer;
import java.util.ArrayList;
import java.util.Scanner;

public class SumArr {
    public static ArrayList<Integer> solution(int n, int m, int[] nAry, int[] mAry){
        int p1 = 0, p2 = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        while(p1<n && p2<m) {
            if(nAry[p1] < mAry[p2]) answer.add(nAry[p1++]);
            else answer.add(mAry[p2++]);
        }
        while(p1<n) answer.add(nAry[p1++]);
        while(p2<m) answer.add(mAry[p2++]);
        return answer;
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
        for(int x : solution(n,m,nAry,mAry)) { System.out.print(x+" ");}
    }
}
