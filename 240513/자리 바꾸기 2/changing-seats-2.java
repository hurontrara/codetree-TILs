import java.io.*;
import java.util.*;

class Person implements Comparable<Person> {

    int number;
    HashSet<Integer> hashSet = new HashSet<>();

    Person(int number) {

        this.number = number;

    }

    @Override
    public int compareTo(Person person) {
        return this.number - person.number;
    }


}

class Change {

    int x;
    int y;

    Change(int x, int y) {
        this.x = x;
        this.y = y;
    }

}


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, k;

    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();

    static Person[] personArray;

    static Change[] changeArray;


    public static void main(String[] args) throws Exception {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        personArray = new Person[n]; changeArray = new Change[k];

        // person 배열 초기화
        for (int i = 0; i < n; i++) {
            personArray[i] = new Person(i);
            personArray[i].hashSet.add(i);
        }

        // change 배열 초기화
        for (int i = 0; i < k; i++) {

            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1; int to = Integer.parseInt(st.nextToken()) - 1;

            changeArray[i] = new Change(from, to);
        }

        // 로직
        // changeArray 배열에 대하여 3번 돌면서 위치 바꾸고, 바꾼 위치 기록
        for (int t = 0; t < 3; t++) {

            for (int i = 0; i < k; i++) {

                Change change = changeArray[i];

                Person frontPerson = personArray[change.x];
                Person backPerson = personArray[change.y];

                frontPerson.hashSet.add(change.y);
                backPerson.hashSet.add(change.x);

                personArray[change.y] = frontPerson;
                personArray[change.x] = backPerson;



            }



        }

        // 정렬하고 출력
        Arrays.sort(personArray);

        for (int i = 0; i < n; i++) {
            Person person = personArray[i];

            sb.append(person.hashSet.size() + "\n");
        }

        System.out.print(sb);





    }




}