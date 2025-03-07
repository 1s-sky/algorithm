import java.io.*;
import java.util.*;
    
class Person {
    int index;
    int time;
    String from;

    public Person(int index, int time, String from){
        this.index = index;
        this.time = time;
        this.from = from;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());   //태울 수 있는 최대 수
        int t = Integer.parseInt(st.nextToken());   //이동하는데 걸리는 시간
        int n = Integer.parseInt(st.nextToken());   //입력 수
        Queue<Person> left = new ArrayDeque<>();    //왼쪽 대기 손님
        Queue<Person> right = new ArrayDeque<>();   //오른쪽 대기 손님
        int[] pArr = new int[n];

        boolean isLeft = true;
        int time = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            Person nowPerson = new Person(i, Integer.parseInt(st.nextToken()), st.nextToken());

            if (nowPerson.from.equals("left")) left.offer(nowPerson);
            else right.offer(nowPerson); 

        }
        
        //배 탈 수 있는지 확인
        while (!left.isEmpty() || !right.isEmpty()) {
            int leftTime = !left.isEmpty()? left.peek().time : Integer.MAX_VALUE; 
            int rightTime = !right.isEmpty()? right.peek().time : Integer.MAX_VALUE;

            int tempTime = Math.min(leftTime, rightTime);   //출발시간
            time = Math.max(time, tempTime);

            if(isLeft && leftTime <= time){  
                int ship = 0;

                while (!left.isEmpty() && ship < m && left.peek().time <= time) {  //사람 태우기
                    pArr[left.poll().index] = time + t;
                    ship++;
                }
                isLeft = false;
            }
            else if(!isLeft && rightTime <= time){   
                int ship = 0;

                while (!right.isEmpty() && ship < m && right.peek().time <= time) {  //사람 태우기
                    pArr[right.poll().index] = time + t;
                    ship++;
                }
                isLeft = true;
            }
            else {
                isLeft = leftTime < rightTime;
            }

            time += t;
        }

        for(int x : pArr){
            System.out.println(x);
        }
    }
}
