import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner kb = new Scanner(System.in);
        int a,b,c;
        
        while(true){
            a = kb.nextInt();
            b = kb.nextInt();
            c = kb.nextInt();
            
            if(a==0 && b==0 && c==0) break;
            
            if((a*a == b*b + c*c) || (b*b == a*a + c*c) || (c*c == a*a + b*b)) sb.append("right").append("\n");
            else sb.append("wrong").append("\n");
        }
        System.out.println(sb.toString());
    }
}