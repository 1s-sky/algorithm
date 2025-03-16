import java.io.*;
import java.util.*;

public class Main {
    static char[][] stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] rooms = new int[n][2];
        int answer = 1;

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            rooms[i][0] = Integer.parseInt(st.nextToken());
            rooms[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(rooms, (o1, o2)->{ 
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        }); //종료시간으로 sort

        int endTime = rooms[0][1];

        for(int i=1; i<n; i++){
            if (rooms[i][0] >= endTime) {   //시작시간이 전 종료시간 이후면
                answer++;
                endTime = rooms[i][1];
            }
        }
        System.out.println(answer);
    }
}
