import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" "); 
        long a = Long.parseLong(str[0]);
        long b = Long.parseLong(str[1]);
        long c  = Long.parseLong(str[2]);
        long result;

        result = modpow(a, b, c);

        System.out.println(result);
    }

    private static long modpow(long a, long b, long c){
        if (b==1) {
            return a % c;
        }
        else {
            long half = modpow(a, b/2, c);

            if (b%2==1) {
                return half * half % c * a % c;
            }
            else return half * half % c;
        }
    }
}