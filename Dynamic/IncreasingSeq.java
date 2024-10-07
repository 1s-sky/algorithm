package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IncreasingSeq {
    private static int[] dy;
    private static int[] arr;

    public static void dynamic(int n){
        if (n==0) {
            dy[n] = 0;
        }
        else{
            for(int i=0; i<n; i++){
                if (arr[i] < arr[n] && dy[i]+1 > dy[n]) {
                    dy[n] = dy[i]+1;
                }
            }
            if (dy[n]==0) dy[n]=1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        dy = new int[n];
        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        for(int i=0; i<n; i++){
            dynamic(i);
        }

        Arrays.sort(dy);
        System.out.println(dy[dy.length - 1]);
    }
}
