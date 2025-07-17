import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int INF = 1000 * 200;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] floyd = new int[n+1][n+1];
        int[][] route = new int[n+1][n+1];
        boolean[][] connect = new boolean[n+1][n+1];

        //초기화
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if (i==j) floyd[i][j] = 0;
                else floyd[i][j] = INF;
                route[i][j] = 0;
            }
        }

        //간선 가중치 입력하기
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()); 
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());;
            floyd[from][to] = weight;
            floyd[to][from] = weight;
            route[from][to] = to;
            route[to][from] = from;
            connect[from][to] = connect[to][from] = true;
        }

        //Floyd
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if (i==j) continue;
                    if(floyd[i][j] > floyd[i][k] + floyd[k][j]) {
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                        route[i][j] = k;
                        route[j][i] = k;

                        boolean isConnect = connect[i][j];
                        int v = route[i][j];
                        while(!isConnect){
                            isConnect = connect[i][v];
                            v = route[i][v];
                        }
                        route[i][j] = route[i][v];
                        
                        isConnect = connect[j][i];
                        v = route[j][i];
                        while(!isConnect){
                            isConnect = connect[j][v];
                            v = route[j][v];
                        }
                        route[j][i] = route[j][v];
                    }
                }
            }
        }

        //출력
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if (route[i][j] == 0) System.out.print("-" + " ");
                else System.out.print(route[i][j] + " ");
            }
            System.out.println();
        }
    }
}