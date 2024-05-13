import java.io.*;
import java.util.*;

class Person implements Comparable<Person> {

    long x;
    long y;
    long distance;

    Person(long x, long y) {

        this.x = x;
        this.y = y;
        this.distance = y - x;

    }

    @Override
    public int compareTo(Person person) {

        return person.distance - this.distance >= 0 ? 1 : -1;

    }


}


public class Main {

    static int n, t; // n명의 사람, t초의 시간

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static TreeSet<Person> treeSet = new TreeSet<>();
    static TreeSet<Long> memoSet = new TreeSet<>();
    
    public static void main(String[] args) throws Exception {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken()); long speed = Long.parseLong(st.nextToken()); long y = x + speed * t;

            treeSet.add(new Person(x, y));

        }

        // distance 역순
        for (Person person : treeSet) {

            Long lowerValue = memoSet.floor(person.x);
            Long higherValue = memoSet.ceiling(person.y);

            if (lowerValue == null) {
                memoSet.add(person.x);
            }

            if (higherValue == null) {
                memoSet.add(person.y);
            }

        }

        System.out.print(memoSet.size() - 1);




    }



}