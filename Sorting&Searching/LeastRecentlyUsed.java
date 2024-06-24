import java.util.Scanner;

public class LeastRecentlyUsed {
    public static int[] solution(int[] cache, int[] work){
        for(int i=0; i<work.length; i++){
            int flag = 0;
            for(int j=0; j<cache.length; j++){
                //캐시에 있다면, 앞으로 당겨오기
                if(work[i] == cache[j]) {
                    flag = 1;
                    for(int k=j; k>0; k--){
                        int temp = cache[k];
                        cache[k] = cache[k-1];
                        cache[k-1] = temp;
                    }
                    break;
                }
            }
            //캐시에 없다면, 마지막꺼 버리기
            if(flag == 0) {
                for(int k=cache.length-1; k>0; k--){
                    int temp = cache[k];
                    cache[k] = cache[k-1];
                    cache[k-1] = temp;
                }
                cache[0] = work[i];
            }
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
