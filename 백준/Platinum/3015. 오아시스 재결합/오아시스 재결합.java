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
        long[] countArr = new long[n];
        long answer = 0;

        ArrayDeque<Person> pStack = new ArrayDeque<>();
        long count = 0;
        
        for(int i=0; i<n; i++){
            Person nowPerson = new Person(Integer.parseInt(br.readLine()));
            count = 0;

            while (!pStack.isEmpty() && pStack.peek().hight <= nowPerson.hight) {
                if (pStack.peek().hight == nowPerson.hight) {
                    nowPerson.same = pStack.peek().same + 1;
                }
                count += pStack.peek().same;
                pStack.pop();
            }

            if(!pStack.isEmpty()){
                count++; 
            }

            countArr[i] = count;
            pStack.push(nowPerson);
        }

        for(long num : countArr){
            answer += num;
        }
        System.out.println(answer);
    }
}