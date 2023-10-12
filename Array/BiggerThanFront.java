/*
1. 큰 수 출력하기
설명

N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.

(첫 번째 수는 무조건 출력한다)


입력
첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.


출력
자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.



 */

import java.util.Scanner;

public class BiggerThanFront{
    public static String solution(int n, int[] nums){
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<n; i++){
            if(i==0) answer.append(nums[i]).append(' ');
            else{
                if(nums[i] > nums[i-1]) answer.append(nums[i]).append(' ');
            }
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = kb.nextInt();
        }
        System.out.println(solution(n, nums));
    }    

}