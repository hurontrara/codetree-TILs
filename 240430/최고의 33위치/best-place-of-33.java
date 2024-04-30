import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;


public class Main {

    static int size;
    static int[][] map;

    static int ans = 0;

    

    public static void main(String[] args) throws Exception {
        
        initialization();

        process();

        System.out.println(ans);

    }

    static void process() {
        
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {

                coinCount(i, j);

            }
        }


    }

    private static void coinCount(int row, int col) {

    int localCount = 0;
    for (int i = row - 1; i <= row + 1; i++) {
        for (int j = col - 1; j <= col + 1; j++) {
            if (map[i][j] == 1)
                localCount++;
        }
    }

    if (localCount > ans)
        ans = localCount;


    }


    

    static void initialization() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        

        for (int i = 0; i < size; i++) {
            map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

    }


}