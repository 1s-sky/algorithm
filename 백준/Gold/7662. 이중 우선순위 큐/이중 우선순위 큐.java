import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            TreeMap<Integer, Integer> tMap = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                if(st.nextToken().equals("I")){ //I일때
                    int n = Integer.parseInt(st.nextToken());
                    tMap.put(n, tMap.getOrDefault(n, 0)+1);
                }
                else{   //D일때
                    if (tMap.isEmpty()) {
                        continue;
                    }

                    if(st.nextToken().equals("1")){ //최댓값 삭제
                        int max = tMap.lastKey();
                        if(tMap.get(max) == 1) {
                            tMap.remove(max);
                        }
                        else tMap.put(max, tMap.get(max)-1);
                    }
                    else{   //최솟값 삭제
                        int min = tMap.firstKey();
                        if(tMap.get(min) == 1) {
                            tMap.remove(min);
                        }
                        else tMap.put(min, tMap.get(min)-1);

                    }

                }
            }
            if (tMap.isEmpty()) sb.append("EMPTY").append('\n');
            else sb.append(tMap.lastKey()).append(' ').append(tMap.firstKey()).append('\n');
        }
        System.out.println(sb.toString());
    }
}