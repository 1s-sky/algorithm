import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int tempX, tempY;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        
		Arrays.sort(arr, (arr1, arr2) -> {
            //return 되는 값이
            //음수 : 위치를 바꾸지 않음
            //양수 : 위치를 바꿈
			if(arr1[0] == arr2[0])  {
				return arr1[1] - arr2[1];
			}
			else {
				return arr1[0] - arr2[0];	
			}
		});
        
        //출력
        for(int i=0; i<n; i++){
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.print(sb);
    }
}