import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> sMap = new HashMap<>();
        int answer = 0;

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            sMap.put(st.nextToken(), st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        String temp = a;

        while (!sMap.getOrDefault(temp, "0").equals("0")) {
            if (sMap.get(temp).equals(b)) {
                answer = 1;
                break;
            }
            temp = sMap.get(temp);
        }

        if (answer == 0) {
            temp = b;
    
            while (!sMap.getOrDefault(temp, "0").equals("0")) {
                if (sMap.get(temp).equals(a)) {
                    answer = 1;
                    break;
                }
                temp = sMap.get(temp);
            }
        }
        System.out.println(answer);
    }
}