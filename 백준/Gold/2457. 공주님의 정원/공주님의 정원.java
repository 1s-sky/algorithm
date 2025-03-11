import java.io.*;
import java.util.*;
    
class Flower {
    int start;
    int end;

    public Flower(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Flower[] garden = new Flower[n];
        int answer = 0;

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String date = "";
            for(int j=0; j<4; j++){
                String nStr = st.nextToken();
                date += nStr.length() == 1 ? '0' + nStr : nStr;
            }
            int start = Integer.parseInt(date.substring(0,4));
            int end = Integer.parseInt(date.substring(4));
            garden[i] = new Flower(start<=301 ? 301 : start, end>=1201 ? 1201 : end);
        }

        Arrays.sort(garden, (o1, o2)-> o1.start - o2.start);

        if (garden[0].start > 301) {
            answer = 0;
        }
        else{
            int before = 301;
            int i=0, maxEnd = 0;;

            while (i<n && before < 1201) {
                boolean found = false;
                while (i<n && garden[i].start <= before) {
                    maxEnd = Math.max(maxEnd, garden[i].end);
                    i++;
                    found = true;
                }
                if (!found) {
                    answer = 0;
                    break;
                }
                answer++;
                before = maxEnd;
                
            }
            if (before < 1201) {
                answer = 0;
            }
        }

        System.out.println(answer);
    }
}