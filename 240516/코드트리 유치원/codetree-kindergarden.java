import java.io.*;
import java.util.*;

class Person {

    int number;
    Person prev = null;
    Person next = null;


    Person(int number) {
        this.number = number;
    }

}


public class Main {

    static int size;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static HashMap<Integer, Person> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        size = Integer.parseInt(br.readLine());

        Person firstPerson = new Person(1);
        hashMap.put(1, firstPerson);

        int idx = 2;
        for (int l = 0; l < size; l++) {

            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if (order == 1 || order == 2) {

                int i = Integer.parseInt(st.nextToken()); int j = Integer.parseInt(st.nextToken());

                // j개의 새로운 로컬 노드를 만들어 잇고
                // 그걸 i번 학생 앞 / 뒤에 잇기
                // j가 3, idx 2면 => 2, 3, 4

                Person leftPerson = new Person(idx);
                hashMap.put(idx, leftPerson);
                Person head = leftPerson;
                for (int k = idx + 1; k < idx + j; k++) {
                    
                    Person presentPerson = new Person(k);

                    hashMap.put(k, presentPerson);

                    presentPerson.prev = leftPerson;

                    leftPerson.next = presentPerson;

                    leftPerson = presentPerson;

                }
                Person tail = leftPerson;
                idx += j;


                // 1이면 뒤 / 2면 앞
                Person left; Person right;
                if (order == 1) {
                    left = hashMap.get(i); // 존재 확실
                    right = left.next; // 존재 불확실

                } else {

                    right = hashMap.get(i);
                    left = right.prev;
                }

                head.prev = left; tail.next = right;

                if (left != null)
                    left.next = head;
                if (right != null)
                    right.prev = tail;



            }
            else {

                Person person = hashMap.get(Integer.parseInt(st.nextToken()));

                if (person.prev == null || person.next == null) {
                    sb.append("-1 \n");
                    continue;
                }

                sb.append(person.prev.number).append(" ").append(person.next.number).append("\n");
                


            }





        }

        System.out.print(sb);


    }


}