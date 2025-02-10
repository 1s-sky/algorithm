package Basic.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TallestTower {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] input = new int[n][3];
        int[] hight = new int[n];

        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split(" ");
            input[i][0] = Integer.parseInt(temp[0]);
            input[i][1] = Integer.parseInt(temp[1]);
            input[i][2] = Integer.parseInt(temp[2]);
        }

        Arrays.sort(input, (o1, o2) -> o2[0] - o1[0]);

        for(int i=0; i<n; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if (input[j][2] > input[i][2] && input[i][1] + hight[j] > max) {  //무게가 덜나가면, 쌓을 수 있다
                    max = input[i][1] + hight[j];
                }
            }
            if (max == 0) hight[i] = input[i][1];
            else hight[i] = max;
        }

        Arrays.sort(hight);
        System.out.println(hight[hight.length - 1]);
    }
}
