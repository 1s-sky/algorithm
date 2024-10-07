import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int cnt = 1; 
        boolean flag = true;
        
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=0; i<arr[0]; i++){
            stack.push(cnt++);
            sb.append("+").append("\n");
        }
        
        stack.pop();
        sb.append("-").append("\n");
        
        for(int i=0; i<n-1; i++){            
            if(arr[i] > arr[i+1]) {
                if(arr[i+1] != stack.peek()) { flag = false; break;}
                stack.pop();
                sb.append("-").append("\n");
            }
            else if(arr[i] < arr[i+1]) {
                for(int j = cnt; j<=arr[i+1]; j++){
                    stack.push(cnt++);
                    sb.append("+").append("\n");   
                }

                if(arr[i+1] != stack.peek()) { flag = false; break;}
                stack.pop(); 
                sb.append("-").append("\n");
                
            }
        }
        if(flag) System.out.println(sb);
        else System.out.println("NO");
    }
}