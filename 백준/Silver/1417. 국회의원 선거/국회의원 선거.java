import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] vote = new int[n+1];
        int count = 0;
        int max = 0;
        int num = 0;

        for(int i=1; i<=n; i++){
            vote[i] = Integer.parseInt(br.readLine());
        }

        for(int i=2; i<=n; i++){
            if (vote[i] > max) {
                max = vote[i];
                num = i;
            }
        }

        while (max >= vote[1]) {
            vote[num]--;
            vote[1]++;
            count++;
            
            max = 0; num = 0;
            for(int i=2; i<=n; i++){
                if (vote[i] > max) {
                    max = vote[i];
                    num = i;
                }
            }
        }

        System.out.println(count);
    }
}