import java.io.*;
import java.util.*;

public class Main {
    public static long seq(HashMap<Long, Long> aMap, long i, long p, long q){
        if(!aMap.containsKey(i)) aMap.put(i, seq(aMap, i/p, p, q) + seq(aMap, i/q, p, q));
        return aMap.get(i);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        // int p = Integer.parseInt(st.nextToken());
        long q = Long.parseLong(st.nextToken());
        // int q = Integer.parseInt(st.nextToken());
        HashMap<Long, Long> aMap = new HashMap<>();
        aMap.put(0L, 1L);
        
        System.out.println(Long.toString(seq(aMap, n, p, q)));
    }
}