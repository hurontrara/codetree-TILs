import java.io.*;
import java.util.*;

class Person implements Comparable<Person> {

    int football;
    int baseball;

    Person(int football, int baseball) {
        this.football = football;
        this.baseball = baseball;
    }

    @Override
    public int compareTo(Person person) {

        if (this.football == person.football) {
            return -1 * (this.baseball - person.baseball);
        }

        return -1 * (this.football - person.football);
    }



}


public class Main {

    static int n;

    static Person[] array;

    static int[][] dpMatrix;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        array = new Person[n]; dpMatrix = new int[1 + 11 + 1][1 + 9 + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            array[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(array);

        dpMatrix[1][0] = array[0].football;
        dpMatrix[0][1] = array[0].baseball;

        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 9; j++) {

                if (dpMatrix[i][j] == 0 || i + j == 20)
                    continue;

                dpMatrix[i + 1][j] = Math.max(dpMatrix[i + 1][j], dpMatrix[i][j] + array[i + j].football);
                dpMatrix[i][j + 1] = Math.max(dpMatrix[i][j + 1], dpMatrix[i][j] + array[i + j].baseball);

            }
        }

        System.out.print(dpMatrix[11][9]);





    }




}