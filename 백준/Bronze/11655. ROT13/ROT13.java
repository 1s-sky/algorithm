import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cAry = br.readLine().toCharArray();

        for (int i = 0; i < cAry.length; i++) {
            char c = cAry[i];
            
            if (c >= 'a' && c <= 'z') {
                c = (char) (c + 13);
                if (c > 'z') {
                    c = (char) (c - 26);
                }
            } else if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 13);
                if (c > 'Z') {
                    c = (char) (c - 26);
                }
            }
            
            cAry[i] = c;
        }

        String result = new String(cAry);
        System.out.println(result);
    }
}