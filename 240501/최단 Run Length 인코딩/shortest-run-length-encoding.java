import java.io.*;
import java.util.stream.Stream;
import java.lang.Math;


public class Main {

    static String[] input;
    static int answer = 100;

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().split("");


        // 로직
        for (int i = 0; i < input.length; i++) {
            rotate();
            calculate();
        }

        // 출력
        System.out.print(answer);


    }

    static void calculate() {

        String recentAlphabet = input[0];
        int count = 1;
        String saveString = "";

        for (int i = 1; i < input.length; i++) {

            if (input[i].equals(recentAlphabet)) {
                count++;
            } else {
                saveString += (recentAlphabet + count);
                recentAlphabet = input[i];
                count = 1;
            }

        }

        saveString += (recentAlphabet + count);

        answer = Math.min(answer, saveString.length());


    }

    static void rotate() {

        String temp = input[input.length - 1];

        for (int i = input.length - 1; i > 0; i--) {
            input[i] = input[i - 1];
        }

        input[0] = temp;

    }




}