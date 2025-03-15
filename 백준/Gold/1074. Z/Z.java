import java.util.*;
import java.io.*;

public class Main{
    static int count = 0;
    static int r, c;

    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int N = (int)Math.pow(2, n);

        z(N, 0, 0);

        System.out.println(count);
    }

    public static void z(int size, int x, int y){
        int half = size / 2;
        if (half < 1) return;

        if(r < x+half && c < y+half){          //1사분면
            z(half, x, y);
        }
        else if(r < x+half && c >= y+half){    //2사분면
            count += half * half;
            z(half, x, y+half);
        }
        else if(r >= x+half && c < y+half){    //3사분면
            count += 2 * half * half;
            z(half, x+half, y);
        }
        else if(r >= x+half && c >= y+half){   //4사분면
            count += 3 * half * half;
            z(half, x+half, y+half);
        }
    }
}