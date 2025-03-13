import java.io.*;
import java.util.*;

public class Main {
    static char[][] stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        stars = new char[n][n];
        int x = 0, y = 0;
        for(int i=0; i<n; i++) Arrays.fill(stars[i], ' ');

        star(n, x, y);
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void star(int n, int x, int y){
        if(n<=1) {
            stars[x][y] = '*';
            return;
        }
    
        for(int i=0; i<3; i++){ 
            for(int j=0; j<3; j++){
                if (i != 1 || j != 1) {
                    star(n/3, x + j*(n/3), y + i*(n/3)); 
                }
            }
        }
    }
}
