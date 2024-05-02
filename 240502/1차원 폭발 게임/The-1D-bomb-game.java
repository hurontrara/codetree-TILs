import java.io.*;

public class Main {

    static int size, m;
    static int[] array;
    static int globalCount;
    static int k = 0;

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] smArray = br.readLine().split(" ");
        size = Integer.parseInt(smArray[0]); m = Integer.parseInt(smArray[1]);
        array = new int[size];
        globalCount = size;
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        // 로직
        while (countAndBomb()) {

        }

        // 출력
        System.out.println(globalCount);
        for (int i = 0; i < size; i++) {
            if (array[i] != 0) 
                System.out.println(array[i]);
            else
                System.exit(0);
        }


    }

    static boolean countAndBomb() {

        int recentValue = array[0];
        int count = 1;
        boolean isBomb = false;

        for (int i = 1; i < size; i++) { 

            if (array[i] == recentValue) {
                count++;
            }
            else {

                if (count >= m && array[i - 1] != 0) {
                    
                    isBomb = true;
                    globalCount -= count;
                    for (int j = 1; j <= count; j++) { 
                        array[i - j] = 0;
                    }

                }

                recentValue = array[i];
                count = 1;

            }

        }

        if (count >= m && array[size - 1] != 0) {

            isBomb = true;
            globalCount -= count;
            for (int j = 0; j < count; j++) { 
                array[size - 1 - j] = 0;
            }

        }

        int tmp = 0;
        int[] tempArray = new int[size];

        for (int i = 0; i < size; i++) {


            if (array[i] != 0) {
                tempArray[tmp++] = array[i];
            }

        }

        for (int i = 0; i < size; i++) {
            array[i] = tempArray[i];
        }



        return isBomb;





    }


}