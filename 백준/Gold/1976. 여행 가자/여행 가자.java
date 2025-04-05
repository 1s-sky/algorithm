import java.util.*;
import java.io.*;

public class Main {
    static int[] root;

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            root[rootB] = root[rootA];  // 부모를 이어줌
        }
    }

    static int find(int des){
        if(root[des] != des){
            root[des] = find(root[des]);
        }
        return root[des];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        root = new int[n];
        for(int i=0; i<n; i++) root[i] = i;

        // 도시 연결
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int isLinked = Integer.parseInt(st.nextToken());
                if(isLinked == 1) union(i, j);
            }
        }

        //여행지 입력받기
        st = new StringTokenizer(br.readLine());
        int travel = find(Integer.parseInt(st.nextToken()) - 1);

        // 연결 검증
        for(int i=1; i<m; i++){
            int city = Integer.parseInt(st.nextToken()) - 1;
            if(find(city)!=travel) {
                System.out.println("NO"); return;
            }
        }

        System.out.println("YES");
    }
}