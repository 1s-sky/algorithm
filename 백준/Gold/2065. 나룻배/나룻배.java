import java.io.*;
import java.util.*;

class Person {
    int index;
    int time;
    String from;

    public Person(int index, int time, String from) {
        this.index = index;
        this.time = time;
        this.from = from;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());   // 태울 수 있는 최대 승객 수
        int t = Integer.parseInt(st.nextToken());   // 이동 시간
        int n = Integer.parseInt(st.nextToken());   // 손님 수

        Queue<Person> left = new LinkedList<>();
        Queue<Person> right = new LinkedList<>();
        int[] pArr = new int[n];

        // 배 초기 위치 및 현재 시간
        boolean isLeft = true;
        int time = 0;

        // 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int arrivalTime = Integer.parseInt(st.nextToken());
            String side = st.nextToken();
            Person nowPerson = new Person(i, arrivalTime, side);

            if (side.equals("left")) left.offer(nowPerson);
            else right.offer(nowPerson);
        }

        // 시뮬레이션 시작
        while (!left.isEmpty() || !right.isEmpty()) {
            int leftTime = (!left.isEmpty()) ? left.peek().time : Integer.MAX_VALUE;
            int rightTime = (!right.isEmpty()) ? right.peek().time : Integer.MAX_VALUE;

            // 배가 출발할 시점 결정
            int nextArrivalTime = Math.min(leftTime, rightTime);
            if (time < nextArrivalTime) {
                time = nextArrivalTime;
            }

            // 현재 배 위치에 따라 태울 승객 결정
            if (isLeft && leftTime <= time) {
                int ship = 0;
                while (!left.isEmpty() && left.peek().time <= time && ship < m) {
                    pArr[left.poll().index] = time + t;
                    ship++;
                }
                isLeft = false; // 오른쪽으로 이동
            } else if (!isLeft && rightTime <= time) {
                int ship = 0;
                while (!right.isEmpty() && right.peek().time <= time && ship < m) {
                    pArr[right.poll().index] = time + t;
                    ship++;
                }
                isLeft = true; // 왼쪽으로 이동
            } else {
                // 대기해야 하는 경우
                isLeft = (leftTime < rightTime);
            }

            // 이동 시간 추가
            time += t;
        }

        // 결과 출력
        for (int x : pArr) {
            System.out.println(x);
        }
    }
}
