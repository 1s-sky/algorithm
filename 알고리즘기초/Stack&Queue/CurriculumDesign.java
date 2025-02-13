import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CurriculumDesign {
    
    public static boolean solution(String check, String str){
        Queue<Character> queue = new LinkedList<>();
        boolean answer = false;

        for(char c : check.toCharArray()){
            queue.add(c);
        }

        for(char c : str.toCharArray()){
            if(c == queue.peek()) queue.poll();
            if(queue.isEmpty()) {
                answer = true;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String check = kb.next();
        String str = kb.next();
        kb.close();

        if(solution(check, str)) System.out.println("YES");
        else System.out.println("NO");
    }
}
