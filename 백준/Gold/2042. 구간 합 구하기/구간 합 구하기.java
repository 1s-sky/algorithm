import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static int leafStart;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int h = (int)Math.ceil(Math.log(n)/Math.log(2));
        int size = (int)Math.pow(2, h+1);   // 루트노드를 1부터 시작
        leafStart = 1 << h;               // 2^h = 리프노드의 개수
        tree = new long[size];

        // 리프노드 채우기
        for(int i=0; i<n; i++){
            tree[leafStart + i] = Long.parseLong(br.readLine());
        }

        // 부모노드 채우기 - 자식합
        for(int i=leafStart-1; i>0; i--){
            tree[i] = tree[i*2] + tree[i*2+1];
        }

        // 변경&출력
        for(int i=0; i<m+k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {    // 변경
                changeTree(leafStart+b-1,c);
            }
            else {          // 출력
                sb.append(sum(leafStart+b-1,leafStart+(int)c-1)).append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    public static void changeTree(int index, long num){
        long diff = num - tree[index];
        while(index > 0){
            tree[index] += diff;
            index /= 2;  //부모로 이동
        }
    }

    public static long sum(int start, int end){
        long sum = 0;
        
        while(start<=end){
            if(start%2==1){ //노드 선택
                sum += tree[start++];
            }
            if(end%2==0){   //노드 선택
                sum += tree[end--];
            }
            start /= 2;
            end /= 2;
        }
        return sum;
    }
}