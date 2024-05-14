import java.io.*;
import java.util.*;

class Unperson implements Comparable<Unperson> {

    int num;
    int arrival;
    int time;

    Unperson(int num, int arrival, int time) {

        this.num = num;
        this.arrival = arrival;
        this.time = time;

    }

    @Override
    public int compareTo(Unperson unperson) {

        if (this.arrival == unperson.arrival) {
            return this.num - unperson.num;
        }

        return this.arrival - unperson.arrival;
    }

}

class Person implements Comparable<Person> {

    int num;
    int arrival;
    int time;

    Person(int num, int arrival, int time) {

        this.num = num;
        this.arrival = arrival;
        this.time = time;

    }

    @Override
    public int compareTo(Person person) {

        return this.num - person.num;
    }

}


public class Main {

    static int size;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Unperson> unpersonQueue = new PriorityQueue<>();
    static PriorityQueue<Person> personQueue = new PriorityQueue<>();

    static int time;

    static int answer = 0;

    public static void main(String[] args) throws Exception {

        size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {

            st = new StringTokenizer(br.readLine());

            unpersonQueue.add(new Unperson(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

        }

        // 초기 설정
        time = 0;

        // 로직
        process();

        // 출력
        System.out.print(answer);


    }


    static void process() {

        queueAdding();
        while (!personQueue.isEmpty()) {

            Person person = personQueue.poll();

            answer = Math.max(answer, time - person.arrival);

            time += person.time;

            queueAdding();

        }

    }

    static void queueAdding() {

        // 도착 큐에서 대기 큐로
        while (!unpersonQueue.isEmpty() && unpersonQueue.peek().arrival <= time) {

            Unperson unperson = unpersonQueue.poll();
            personQueue.add(new Person(unperson.num, unperson.arrival, unperson.time));

        }

        // 만약 현재 시간보다 늦으면 시간 변경해야함
        if (!unpersonQueue.isEmpty() && personQueue.isEmpty()) {

            Unperson unperson = unpersonQueue.poll();
            personQueue.add(new Person(unperson.num, unperson.arrival, unperson.time));
            time = unperson.arrival;

        }

    }




}