import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int left = 0, right = trees[n-1];

        while(left <= right){
            int mid = (left + right) / 2;

            long sum = 0;
            for(int j=0; j<n; j++){
                sum += trees[j] > mid ? trees[j] - mid : 0;
                if (sum >= m) break;
            }

            if (sum >= m) {
                answer = mid;
                left = mid + 1;    
            }
            else {
                right = mid - 1;
            }

        }
        System.out.println(answer);
    }
}