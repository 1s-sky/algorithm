import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Integer>[] adj;
    static int[] answer;
    static boolean[] isVisted;

    public static void circuit(int root){
        if (adj[root] == null) {
            return;
        }
        for(int i=0; i<adj[root].size(); i++){
            if(isVisted[adj[root].get(i)]) continue;
            answer[adj[root].get(i)] = root;
            isVisted[root] = true;

            circuit(adj[root].get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        adj = new LinkedList[n+1];
        answer = new int[n+1];
        isVisted = new boolean[n+1];

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if(adj[l] == null) adj[l] = new LinkedList<>();
            adj[l].add(k);
            if(adj[k] == null) adj[k] = new LinkedList<>();
            adj[k].add(l);
        }

        circuit(1);

        for(int i=2; i<=n; i++){
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb.toString());
    }
}
