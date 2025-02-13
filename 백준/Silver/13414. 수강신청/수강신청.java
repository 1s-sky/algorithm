import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int max = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> count = new HashMap<>();
        Queue<String> studentQue = new LinkedList<String>();

        for(int i=0; i<n; i++){
            String number = br.readLine();
            studentQue.add(number);
            count.put(number, count.getOrDefault(number, 0)+1);
        }

        int checkMax = 0;
        while ((checkMax < max) && !studentQue.isEmpty()) {
            String student = studentQue.poll();
            if(count.get(student) > 1) {
                count.put(student, count.get(student)-1);
                continue;
            }
            sb.append(student).append('\n');
            checkMax++;
        }
        System.out.println(sb.toString());
    }
}