import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> stuTime = new HashMap<>();
        HashMap<String, Integer> stuMoney = new HashMap<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] timeStr = st.nextToken().split(":");
            int hour = Integer.parseInt(timeStr[0]);
            int minute = Integer.parseInt(timeStr[1]);
            int time = hour * 60 + minute;
            String name = st.nextToken();

            stuTime.put(name, stuTime.getOrDefault(name, 0)+time);
        }

        //요금 계산
        for(String student : stuTime.keySet()){
            double totTime = stuTime.get(student);
            if(totTime > 100) {
                stuMoney.put(student, 10 + (int)Math.ceil((totTime - 100)/50)*3);
            }
            else stuMoney.put(student, 10);
        }

        //Sort 재정의
        List<Map.Entry<String, Integer>> mapList = new ArrayList<>(stuMoney.entrySet());
    
        mapList.sort((o1, o2) -> {
            if (o2.getValue().compareTo(o1.getValue()) == 0) {  //같으면 이름으로도 비교
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });

        for(Map.Entry<String, Integer> entry : mapList){
            sb.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
        }

        System.out.println(sb.toString());
    }
}