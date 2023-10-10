import java.util.Scanner;

public class Code {
    public static String solution(int n, String str){
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<n; i++){
            String sub = str.substring(0, 7).replace('#', '1').replace('*', '0');
            answer.append((char)Integer.parseInt(sub, 2));
            str = str.substring(7);
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String input = kb.next();
        System.out.println(solution(n, input));
        kb.close();
    }  
}
