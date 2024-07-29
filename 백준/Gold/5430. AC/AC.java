import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            Deque<Integer> deque = new ArrayDeque<>();
            boolean isReversed = false;
            boolean isRight = true;
            //함수
            String p = br.readLine();
            //배열개수
            int n = Integer.parseInt(br.readLine());
            //배열받기
            int[] arr = new int[n];
            String str = br.readLine();
            
            //String 가공(콤마, []제거)
            String[] str2 = str.substring(1, str.length()-1).split(",");
            for(int j=0; j<n; j++) {
                arr[j] = Integer.parseInt(str2[j]);
                deque.add(arr[j]);
            }

            //함수 실행하기
            for(char x : p.toCharArray()){
                if(x == 'R'){
                    isReversed = !isReversed;
                }   
                else if(x == 'D'){
                    if(deque.isEmpty()){
                        isRight = false;
                        break;
                    }

                    if (isReversed) {
                        //뒤집혀있으면 뒤에서 빼기
                        deque.removeLast();
                    }
                    else{
                        //안뒤집혀있으면 앞에서 빼기
                        deque.removeFirst();
                    }
                }
            }

            if (!isRight) sb.append("error" + "\n");
            else {
                //size가 0인지 체크
                if(deque.isEmpty()){
                    sb.append("[]").append("\n");
                    continue;
                }
                sb.append("[");
                //뒤집혔는지 확인
                while(!deque.isEmpty()){
                    if(isReversed) {
                    sb.append(deque.removeLast()).append(",");
                    }
                    else sb.append(deque.removeFirst()).append(","); 
                }

                // 마지막 콤마 제거
                if (sb.length() > 1) {
                    sb.setLength(sb.length()-1);
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}