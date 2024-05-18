import java.io.*;
import java.util.*;

class Person implements Comparable<Person> {

    int num;
    int time;
    int coef;

    Person(int num, int time, int coef) {
        this.num = num;
        this.time = time;
        this.coef = coef;
    }

    @Override
    public int compareTo(Person person) {
        return this.time - person.time;
    }

}


public class Main {

    static int n;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Person> personQueue = new PriorityQueue<>();
    static PriorityQueue<Integer> computerQueue = new PriorityQueue<>();

    static HashMap<Integer, Integer> hashMap = new HashMap<>(); // 사람 -> 컴퓨터

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());

            personQueue.add(new Person(i, a, 1)); personQueue.add(new Person(i, b, -1));


        }

        for (int i = 1; i <= n; i++) {

            computerQueue.add(i);

        }

        while (!personQueue.isEmpty()) {

            Person person = personQueue.poll();

            // 들어가는 경우
            if (person.coef == 1) {

                hashMap.put(person.num, computerQueue.poll());

            }

            else {

                int computerNum = hashMap.get(person.num);

                computerQueue.add(computerNum);

            }


        }

        for (int i = 0; i < n; i++) {

            sb.append(hashMap.get(i)).append(" ");

        }

        System.out.print(sb);







    }




}