import java.io.*;
import java.util.*;

class Node {
    int child;
    int weight;
    public Node(int child, int weight){
        this.child = child;
        this.weight = weight;
    }
}

public class Main {
    static ArrayList<Node>[] tree;
    static boolean[] isVisited;
    static int maxDist;
    static int farestNode = 1;  //N==1 일때 가장 먼 노드는 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        isVisited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        dfs(1, 0);          // 가장 먼 노드 찾기

        maxDist = 0;
        Arrays.fill(isVisited,false);    
        dfs(farestNode, 0);        // 지름 찾기

        System.out.println(maxDist);
    }

    public static void dfs(int parent, int distance){
        isVisited[parent] = true;
        if(distance > maxDist){
            maxDist = distance;
            farestNode = parent;
        }

        for(Node node : tree[parent]) {
            if(!isVisited[node.child]) dfs(node.child, distance+node.weight);
        }
    }
}