import java.io.*;
import java.util.*;
    
class Person {
    int hight;
    int same;

    public Person(int hight){
        this.hight = hight;
        this.same = 1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 0;

        ArrayDeque<Person> pStack = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            Person nowPerson = new Person(Integer.parseInt(br.readLine()));

            while (!pStack.isEmpty() && pStack.peek().hight <= nowPerson.hight) {
                if (pStack.peek().hight == nowPerson.hight) {
                    nowPerson.same = pStack.peek().same + 1;
                }
                answer += pStack.peek().same;
                pStack.pop();
            }

            if(!pStack.isEmpty()){
                answer++; 
            }

            pStack.push(nowPerson);
        }

        System.out.println(answer);
    }
}