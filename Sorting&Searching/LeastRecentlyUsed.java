import java.util.Scanner;

public class LeastRecentlyUsed {
    public static int[] solution(int[] cache, int[] work){
        for(int i=0; i<work.length; i++){
            int pos = -1;
            for(int j=0; j<cache.length; j++){
                if(work[i] == cache[j]) {
                    pos = j;
                    break;
                }
            }
            //캐시에 없다면, 끝까지 밀기
            if(pos == -1) {
                for(int k=cache.length-1; k>0; k--){
                    cache[k] = cache[k-1];
                }
            }
            //캐시에 있다면, 인덱스까지만 밀기
            else{
                for(int k=pos; k>0; k--){
                    cache[k] = cache[k-1];
                }
            }
            cache[0] = work[i];
        }

        return cache;
    } 

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] cache = new int[n];
        int[] work = new int[k];

        for(int i=0; i<k; i++){
            work[i] = kb.nextInt();
        }
        kb.close();

        for(int i : solution(cache, work)){
            System.out.print(i);
            System.out.print(' ');
        }
    }
}
