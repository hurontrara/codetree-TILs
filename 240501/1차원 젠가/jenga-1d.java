import java.io.*;
import java.util.stream.Stream;

public class Main {

    static int size;
    static int[] array;
    static int length;


    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        array = new int[size];
        length = size;
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        // 로직
        for (int i = 0; i < 2; i++) {

            String[] blockArray = br.readLine().split(" ");

            int first = Integer.parseInt(blockArray[0]) - 1; int second = Integer.parseInt(blockArray[1]) - 1;

            cracking(first, second);

            length -= second - first + 1;
        }

        // 출력
        System.out.println(length);
        for (int i = 0; i < size; i++) {
            if (array[i] == 0)
                System.exit(0);
            else
                System.out.println(array[i]);
        }


    }

    static void cracking(int first, int second) {

        int[] tempArray = new int[size];

        for (int i = first; i <= second; i++) { 
            array[i] = 0;
        }

        int tempIdx = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] > 0) {
                tempArray[tempIdx++] = array[i];
            }
        }

        for (int i = 0; i < size; i++) {
            array[i] = tempArray[i];
        }



    }


}