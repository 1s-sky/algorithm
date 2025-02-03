import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] nAry = new int[n];
        int answer = 0, start = 0, end = 0, cnt = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nAry[i] = Integer.parseInt(st.nextToken());
        }

        while(start<n && end<n){
            if (nAry[end]%2 != 0) { 
                cnt++;
                while (cnt > k) {
                    if (nAry[start]%2 != 0) {
                        cnt--;
                    }
                    start++;
                }
            }

            answer = Math.max(answer, end-start+1-cnt);
            end++;
        }
        System.out.println(answer);
    }
}