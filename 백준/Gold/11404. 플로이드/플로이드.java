import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int INF = 100000 * 100;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] floyd = new int[n][n];

        //초기화
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (i==j) floyd[i][j] = 0;
                else floyd[i][j] = INF;
            }
        }

        //간선 가중치 입력하기
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1; 
            int to = Integer.parseInt(st.nextToken()) - 1;
            floyd[from][to] = Math.min(floyd[from][to], Integer.parseInt(st.nextToken()));
        }

        //Floyd
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if (i==j) continue;
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                }
            }
        }

        //출력
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (floyd[i][j] >= INF) System.out.print(0 + " ");
                else System.out.print(floyd[i][j] + " ");
            }
            System.out.println();
        }
    }
}