import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            switch (str[0]) {
                case "push":
                    stack.addFirst(Integer.parseInt(str[1]));
                    break;

                case "pop":
                    if (stack.isEmpty()) sb.append("-1\n");
                    else sb.append(stack.pop()).append("\n");
                    break;

                case "size":
                    sb.append(stack.size()).append("\n");
                    break;

                case "empty":
                    if(stack.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;

                case "top":
                    if (stack.isEmpty()) sb.append("-1\n");
                    else sb.append(stack.peek()).append("\n");
                    break;

                default:
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}