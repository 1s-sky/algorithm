import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int[][] paper;
    static int[] answer;

    static void checkColor(int x, int y, int n) {
        int color = paper[x][y];
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if (paper[i][j] != color) {
                    checkColor(x, y, n/2);
                    checkColor(x, y+n/2, n/2);
                    checkColor(x+n/2, y, n/2);
                    checkColor(x+n/2, y+n/2, n/2);
                    return;
                }
            }
        }

        answer[color]++; 
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        answer = new int[2];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkColor(0,0, n);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}