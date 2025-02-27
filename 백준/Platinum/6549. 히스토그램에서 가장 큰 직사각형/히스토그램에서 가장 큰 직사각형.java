import java.io.*;
import java.util.*;
    
class Block {
    int index;
    long hight;

    public Block(int index, int hight){
        this.index = index;
        this.hight = hight;
    }
}

public class Main {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String input = br.readLine();

    while (!input.equals("0")) {
        ArrayDeque<Block> bStack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        long area = 0;
        
        for(int i=0; i<n; i++){
            Block nowBlock = new Block(i, Integer.parseInt(st.nextToken()));
            Block beforeBlock;
            long hight = Integer.MAX_VALUE;
            long width = 0;
            while (!bStack.isEmpty() && bStack.peek().hight > nowBlock.hight) {
                beforeBlock = bStack.pop();
                hight = Math.min(hight, beforeBlock.hight);
                width = bStack.isEmpty() ? i : i - bStack.peek().index - 1;

                area = Math.max(area, hight * width);
            }
            bStack.push(nowBlock);

        }

        Block beforeBlock;
        long hight = Integer.MAX_VALUE;
        long width = 0;

        while (!bStack.isEmpty()) {
            beforeBlock = bStack.pop();
            hight = Math.min(hight, beforeBlock.hight);
            width = bStack.isEmpty() ? n : n - bStack.peek().index - 1;

            area = Math.max(area, hight * width);
        }

        sb.append(area).append('\n');
        input = br.readLine();
    }
    
    System.out.println(sb.toString());
}
}