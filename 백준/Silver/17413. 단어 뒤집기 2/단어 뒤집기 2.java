import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] cAry = br.readLine().toCharArray(); 

        int start = 0, end = 0;

        while(start<cAry.length && end<cAry.length){
            if (cAry[start] == '<') {  // <를 만나면 >를 만날때 까지 이동
                if (cAry[end] == '>') {
                    String str = new String(cAry);
                    sb.append(str.substring(start, end + 1));
                    start = ++end;
                    continue;
                }
                else { end++; continue; }
            }
            else{
                if (end == cAry.length-1 || cAry[end+1] == '<') {

                    String[] sAry = new String(cAry).substring(start, end + 1).split(" ");

                    for(String str : sAry){
                        int s = 0;
                        int e = str.length()-1;
                        char temp;
                        char[] stemp = str.toCharArray();

                        while (s<e) {
                            temp = stemp[s];
                            stemp[s] = stemp[e];
                            stemp[e] = temp;
                            s++; e--;
                        }

                        sb.append(stemp).append(" ");
                    }
                    sb.setLength(sb.length() - 1);
                    start = ++end;
                    continue;
                }
                else{ end++; continue; }
            }
        }

        System.out.println(sb.toString());
    }
}