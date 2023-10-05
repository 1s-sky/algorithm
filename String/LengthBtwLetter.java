import java.util.Scanner;

public class LengthBtwLetter {
    public static int[] solution(String str, char t) {
        int length = 1000;
        int[] answer = new int[str.length()];

        //왼쪽의 문자 t에서부터 떨어진 거리
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == t) length = 0;
            else length++;
            answer[i] = length;
        }
        //오른쪽의 문자 t에서부터 떨어진 거리
        length = 1000;
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) == t) length=0;
            else length++;
            if(answer[i] > length){
                answer[i] = length;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char t = kb.next().charAt(0);
        for(int x : solution(str,t)){
            System.out.print(x + " ");
        }
        kb.close();
    }
}
