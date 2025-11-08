import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> line = new ArrayDeque<>();
        Deque<Integer> wait = new ArrayDeque<>();
        int number = 1;

        for(int i=0; i<n; i++){
            line.add(Integer.parseInt(st.nextToken()));
        }

        while (!line.isEmpty()) {
            if (line.peek() == number) {
                line.pop();
                number++;
            }
            else if (!wait.isEmpty() && wait.peek() == number) {
                wait.pop();
                number++;
            }
            else {
                wait.push(line.pop());
            }
        }

        while (!wait.isEmpty()) {
            if (wait.peek() == number) {
                wait.pop();
                number++;
            }
            else {
                break;
            }
        }

        if (line.isEmpty() && wait.isEmpty()) System.out.print("Nice");
        else System.out.print("Sad");
    }
}