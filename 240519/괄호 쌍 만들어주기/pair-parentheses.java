import java.io.*;
import java.util.*;


public class Main {

    static char[] array;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] leftCount;
    static int[] rightCount;

    public static void main(String[] args) throws Exception {

        array = br.readLine().toCharArray();
        leftCount = new int[array.length]; rightCount = new int[array.length];

        for (int i = 1; i < array.length; i++) {

            char afterInput = array[i];
            char beforeInput = array[i - 1];

            leftCount[i] = leftCount[i - 1];
            rightCount[i] = rightCount[i - 1];

            if (afterInput == '(' && beforeInput == '(')
                leftCount[i] += 1;
            else if (afterInput == ')' && beforeInput == ')')
                rightCount[i] += 1;


        }

        long answer = 0;
        for (int i = 3; i < array.length; i++) {


            if (rightCount[i] != rightCount[i - 1]) {

                answer += (long) leftCount[i - 2];


            }


        }
        System.out.print(answer);




    }


}



// long 타입 사용