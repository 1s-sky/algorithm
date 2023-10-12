import java.util.Scanner;

public class ReverseWord {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        for(int i=0; i<n; i++){
            StringBuilder answer = new StringBuilder(kb.next());
            System.out.println(answer.reverse());
        }
        kb.close();
        return;
    }
}
