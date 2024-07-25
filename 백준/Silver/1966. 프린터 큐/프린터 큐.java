import java.io.*;
import java.util.*;

public class Main{
    public static int solution(int m, LinkedList<Integer> que){
        int i = 0, count = 1;

        while(!que.isEmpty()){
            for(i=0; i<que.size(); i++){
                //큰 값이 하나라도 있으면
                if(que.peek() < que.get(i)) {
                    //맨 앞을 맨 뒤로
                    if(m==0) m = que.size() - 1;
                    else m--;
                    
                    que.add(que.removeFirst());
                    break;
                }
            }

            //큰값이 없으면
            if(i == que.size()) {
                que.removeFirst();
                if(m==0) break;
                else {                    
                    m--; count++;
                }
            }
        }    
        return count; 
    }

    public static void main(String args[]){
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        int n, m;
        StringBuilder sb = new StringBuilder(); 

        for(int i=0; i<k; i++){
            n = kb.nextInt();
            m = kb.nextInt();
            LinkedList<Integer> que = new LinkedList<>();

            for(int j=0; j<n; j++){
                que.add(kb.nextInt());
            }  
            sb.append(solution(m, que)).append('\n');
        }
        kb.close();

        System.out.println(sb.toString());
    }
}